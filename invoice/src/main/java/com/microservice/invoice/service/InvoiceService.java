package com.microservice.invoice.service;

import com.microservice.invoice.entity.Invoice;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    List<Invoice> findAll();
    Optional<Invoice> findById(Integer id);
    Invoice save(Invoice invoice);

}
