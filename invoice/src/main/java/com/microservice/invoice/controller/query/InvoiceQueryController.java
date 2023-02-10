package com.microservice.invoice.controller.query;

import com.microservice.invoice.dto.InvoiceGetDTO;
import com.microservice.invoice.service.query.InvoiceQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/invoice/client/{clientId}")
    public ResponseEntity<?> findAllInvoices(@PathVariable("clientId") Integer clientId){
        List<InvoiceGetDTO> invoicesDto = invoiceService.findByClientId(clientId);
        if(invoicesDto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not invoices for this client");
        }
        return ResponseEntity.status(HttpStatus.OK).body(invoicesDto);
    }

    @GetMapping("/invoice/{invoiceId}")
    public ResponseEntity<?> findInvoiceById(@PathVariable("invoiceId") Integer id){
        InvoiceGetDTO invoice = invoiceService.findById(id);
        if(invoice==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invoice Not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(invoice);
    }

    @GetMapping("/invoice/sales/today")
    public ResponseEntity<?> findTodayTotalSales(){
        Map<String, Double> totalSales = new HashMap<>();
        totalSales.put("today", invoiceService.findByDate());
        totalSales.put("month", invoiceService.findTotalSalesByMonth());
        return ResponseEntity.status(HttpStatus.OK).body(totalSales);
    }

    @GetMapping("/invoice/sales/week")
    public ResponseEntity<?> findTotalWeekSales(){
        return ResponseEntity.status(HttpStatus.OK).body(invoiceService.findSalesLastWeek());
    }


}
