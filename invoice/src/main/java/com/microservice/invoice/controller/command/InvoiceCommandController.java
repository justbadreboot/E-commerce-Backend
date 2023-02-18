package com.microservice.invoice.controller.command;

import com.microservice.invoice.dto.InvoiceGetDTO;
import com.microservice.invoice.dto.order.OrderPostDTO;
import com.microservice.invoice.service.command.InvoiceCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
@Slf4j
public class InvoiceCommandController {
    @Autowired
    private InvoiceCommandService invoiceCommandService;

    @PostMapping("/repartidor/invoice/order")
    public InvoiceGetDTO createInvoiceByOrder(@RequestBody @Valid OrderPostDTO orderDto){
        log.info("Inside method to create one invoice");
        return invoiceCommandService.createInvoice(orderDto);
    }
}
