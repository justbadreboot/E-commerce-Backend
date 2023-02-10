package com.microservice.invoice.service.query;

import com.microservice.invoice.dto.InvoiceGetDTO;
import com.microservice.invoice.entity.Invoice;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface InvoiceQueryService {
    List<InvoiceGetDTO> findAll();
    List<InvoiceGetDTO> findByClientId(Integer id);
    InvoiceGetDTO findById(Integer id);
    Double findByDate();
    Double findTotalSalesByMonth();

}
