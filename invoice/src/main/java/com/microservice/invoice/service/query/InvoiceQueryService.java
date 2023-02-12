package com.microservice.invoice.service.query;

import com.microservice.invoice.dto.InvoiceGetDTO;
import com.microservice.invoice.dto.TotalSalesGetDTO;

import java.util.List;

public interface InvoiceQueryService {
    List<InvoiceGetDTO> findAll();
    List<InvoiceGetDTO> findByClientId(Integer id);
    InvoiceGetDTO findById(Integer id);
    TotalSalesGetDTO findTotalSales();
    List<?> findSalesLastWeek();

}
