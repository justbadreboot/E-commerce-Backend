package com.microservice.invoice.service.query;

import com.microservice.invoice.dto.InvoiceGetDTO;

import java.util.List;

public interface InvoiceQueryService {
    List<InvoiceGetDTO> findAll();
    List<InvoiceGetDTO> findByClientId(Integer id);
    InvoiceGetDTO findById(Integer id);
    Double findByDate();
    Double findTotalSalesByMonth();
    List<?> findSalesLastWeek();

}
