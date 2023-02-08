package com.microservice.invoice.service.query;

import com.microservice.invoice.dto.InvoiceGetDTO;
import com.microservice.invoice.entity.Invoice;
import com.microservice.invoice.entity.InvoiceDetail;
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
public class InvoiceQueryServiceImpl implements InvoiceQueryService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    private InvoiceMapper invoiceMapper;

    @Override
    public List<InvoiceGetDTO> findAll() {
        return invoiceMapper.toInvoicesDto(invoiceRepository.findAll());
    }

    @Override
    public InvoiceGetDTO findById(Integer id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        return invoice.map(value -> invoiceMapper.toInvoiceDto(value)).orElse(null);

    }


}
