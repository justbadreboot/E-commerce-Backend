package com.microservice.invoice.repository;

import com.microservice.invoice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    List<Invoice> findByClientId(Integer id);
}
