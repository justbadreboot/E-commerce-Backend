package com.microservice.invoice.controller.command;

import com.microservice.invoice.dto.InvoicePostDTO;
import com.microservice.invoice.entity.Invoice;
import com.microservice.invoice.service.command.InvoiceCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class InvoiceCommandController {
    @Autowired
    private InvoiceCommandService invoiceCommandService;

    @PostMapping("/invoice")
    public Invoice createInvoice(@RequestBody InvoicePostDTO invoiceDto){
        invoiceDto.setDate(LocalDateTime.now());
        return invoiceCommandService.save(invoiceDto);
    }
}
