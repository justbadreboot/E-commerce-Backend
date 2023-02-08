package com.microservice.invoice.controller.query;

import com.microservice.invoice.dto.InvoiceGetDTO;
import com.microservice.invoice.service.query.InvoiceQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class InvoiceQueryController {
    @Autowired
    private InvoiceQueryService invoiceService;

    @GetMapping("/invoice")
    public ResponseEntity<?> findAllInvoices(){
        List<InvoiceGetDTO> invoices = invoiceService.findAll();
        if(invoices.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not invoices yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(invoices);
    }

    @GetMapping("/invoice/{invoiceId}")
    public ResponseEntity<?> findInvoiceById(@RequestParam("invoiceId") Integer id){
        InvoiceGetDTO invoice = invoiceService.findById(id);
        if(invoice==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invoice Not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(invoice);
    }

}
