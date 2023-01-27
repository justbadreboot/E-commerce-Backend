package com.microservice.invoice.service;

import com.microservice.invoice.entity.Invoice;
import com.microservice.invoice.entity.InvoiceDetail;
import com.microservice.invoice.repository.InvoiceDetailRepository;
import com.microservice.invoice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InvoiceServiceImpl implements  InvoiceService{
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Optional<Invoice> findById(Integer id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public Invoice save(Invoice invoice) {
        List<InvoiceDetail> details = invoice.getDetails();
        List<InvoiceDetail> detailsAdded = new ArrayList<>();

        invoice.setDetails(null);
        Invoice invoiceAdded =  invoiceRepository.save(invoice);

        for (InvoiceDetail detail: details) {
            detail.setInvoice(invoiceAdded);
            detailsAdded.add(detail);
        }
        invoiceDetailRepository.saveAll(detailsAdded);
        invoiceAdded.setDetails(detailsAdded);
        invoiceRepository.save(invoiceAdded);
        return invoiceAdded;
    }
}
