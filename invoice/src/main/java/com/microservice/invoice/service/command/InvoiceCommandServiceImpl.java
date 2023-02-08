package com.microservice.invoice.service.command;

import com.microservice.invoice.dto.InvoicePostDTO;
import com.microservice.invoice.entity.Invoice;
import com.microservice.invoice.entity.InvoiceDetail;
import com.microservice.invoice.mapper.InvoiceDetailMapper;
import com.microservice.invoice.mapper.InvoiceMapper;
import com.microservice.invoice.repository.InvoiceDetailRepository;
import com.microservice.invoice.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class InvoiceCommandServiceImpl implements InvoiceCommandService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;
    private InvoiceMapper invoiceMapper;
    private InvoiceDetailMapper invoiceDetailMapper;
    @Override
    public Invoice save(InvoicePostDTO invoiceDto) {
        List<InvoiceDetail> details = invoiceDetailMapper.toInvoiceDetails(invoiceDto.getDetails());
        Invoice invoice = invoiceMapper.toInvoice(invoiceDto);
        invoice.setDetails(null);
        invoiceRepository.save(invoice);
        for (InvoiceDetail detail: details) {
            detail.setInvoiceId(invoice.getId());
        }
        invoice.setDetails(invoiceDetailRepository.saveAll(details));
        return invoice;
    }
}
