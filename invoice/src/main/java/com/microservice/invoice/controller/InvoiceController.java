package com.microservice.invoice.controller;

import com.microservice.invoice.entity.Invoice;
import com.microservice.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/invoice")
    public ResponseEntity<?> findAllInvoices(){
        List<Invoice> invoices = invoiceService.findAll();
        if(invoices.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not invoices yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(invoices);
    }

    @GetMapping("/invoice/{invoiceId}")
    public ResponseEntity<?> findInvoiceById(@RequestParam("invoiceId") Integer id){
        Optional<Invoice> invoice = invoiceService.findById(id);
        if(invoice.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invoice Not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(invoice);
    }

    @PostMapping("/invoice")
    public Invoice createInvoice(@RequestBody Invoice invoice){
        invoice.setDate(LocalDateTime.now());
        return invoiceService.save(invoice);
    }

}
