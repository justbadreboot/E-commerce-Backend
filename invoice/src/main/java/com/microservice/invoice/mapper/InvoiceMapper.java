package com.microservice.invoice.mapper;

import com.microservice.invoice.dto.InvoiceGetDTO;
import com.microservice.invoice.dto.InvoicePostDTO;
import com.microservice.invoice.entity.Invoice;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    InvoiceGetDTO toInvoiceDto(Invoice invoice);
    List<InvoiceGetDTO> toInvoicesDto(List<Invoice> invoices);
    Invoice toInvoice(InvoicePostDTO invoiceDto);

}
