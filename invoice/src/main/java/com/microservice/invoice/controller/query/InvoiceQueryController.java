package com.microservice.invoice.controller.query;

import com.microservice.invoice.dto.InvoiceGetDTO;
import com.microservice.invoice.dto.TotalSalesGetDTO;
import com.microservice.invoice.service.query.InvoiceQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
@Slf4j
public class InvoiceQueryController {
    @Autowired
    private InvoiceQueryService invoiceService;

    @GetMapping("/invoice")
    public ResponseEntity<?> findAllInvoices(){
        log.info("Inside method to find all invoices");
        List<InvoiceGetDTO> invoices = invoiceService.findAll();
        if(invoices.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not invoices yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(invoices);
    }

    @GetMapping("/invoice/client/{clientId}")
    public ResponseEntity<?> findAllInvoices(@PathVariable("clientId") Integer clientId){
        log.info("Inside method to find all invoices by client");
        List<InvoiceGetDTO> invoicesDto = invoiceService.findByClientId(clientId);
        if(invoicesDto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not invoices for this client");
        }
        return ResponseEntity.status(HttpStatus.OK).body(invoicesDto);
    }

    @GetMapping("/invoice/{invoiceId}")
    public ResponseEntity<?> findInvoiceById(@PathVariable("invoiceId") Integer id){
        log.info("Inside method to find one invoice by id");
        InvoiceGetDTO invoice = invoiceService.findById(id);
        if(invoice==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invoice Not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(invoice);
    }

    @GetMapping("/invoice/sales/today")
    public ResponseEntity<?> findTodayTotalSales(){
        log.info("Inside method to get total sales by actual day");
        TotalSalesGetDTO totals = invoiceService.findTotalSales();
        return ResponseEntity.status(HttpStatus.OK).body(totals);
    }

    @GetMapping("/invoice/sales/week")
    public ResponseEntity<?> findTotalWeekSales() throws ParseException {
        log.info("Inside method to get total sales by week");
        return ResponseEntity.status(HttpStatus.OK).body(invoiceService.findSalesLastWeek());
    }

    @GetMapping("/invoice/sales/month")
    public ResponseEntity<?> findTotalSalesByAllMonth(){
        log.info("Inside method to get total sales by month");
        return ResponseEntity.status(HttpStatus.OK).body(invoiceService.findAllMonthSales());
    }
}