package com.microservice.invoice.controller.command;

import com.microservice.invoice.dto.InvoiceGetDTO;
import com.microservice.invoice.dto.order.OrderPostDTO;
import com.microservice.invoice.service.command.InvoiceCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class InvoiceCommandController {
    @Autowired
    private InvoiceCommandService invoiceCommandService;

    @PostMapping("/invoice/order")
    public InvoiceGetDTO createInvoiceByOrder(@RequestBody @Valid OrderPostDTO orderDto){
        return invoiceCommandService.createInvoice(orderDto);
    }
}
