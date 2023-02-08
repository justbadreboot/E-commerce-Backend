package com.microservice.invoice.mapper;

import com.microservice.invoice.dto.InvoiceDetailGetDTO;
import com.microservice.invoice.dto.InvoiceDetailPostDTO;
import com.microservice.invoice.entity.InvoiceDetail;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceDetailMapper {

    InvoiceDetailGetDTO toInvoiceDetailDto(InvoiceDetail invoiceDetail);
    List<InvoiceDetailGetDTO> toInvoiceDetailsDto(List<InvoiceDetailGetDTO> invoiceDetails);
    InvoiceDetail toInvoiceDetail(InvoiceDetailPostDTO invoiceDetailDto);

}
