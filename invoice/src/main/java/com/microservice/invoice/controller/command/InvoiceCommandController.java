package com.microservice.invoice.controller.command;

import com.microservice.invoice.dto.InvoiceGetDTO;
import com.microservice.invoice.dto.InvoicePostDTO;
import com.microservice.invoice.dto.order.OrderPostDTO;
import com.microservice.invoice.entity.Invoice;
import com.microservice.invoice.service.command.InvoiceCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class InvoiceCommandController {
    @Autowired
    private InvoiceCommandService invoiceCommandService;

    @PostMapping("/invoice/order")
    public InvoiceGetDTO createInvoiceByOrder(@RequestBody OrderPostDTO orderDto){
        return invoiceCommandService.createInvoice(orderDto);
    }
}
