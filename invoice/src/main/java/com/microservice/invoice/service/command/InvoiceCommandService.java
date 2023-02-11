package com.microservice.invoice.service.command;

import com.microservice.invoice.dto.InvoiceGetDTO;
import com.microservice.invoice.dto.InvoicePostDTO;
import com.microservice.invoice.dto.order.OrderPostDTO;
import com.microservice.invoice.entity.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceCommandService {
    Invoice save(InvoicePostDTO invoiceDto);
    InvoiceGetDTO createInvoice(OrderPostDTO orderDto);
}
