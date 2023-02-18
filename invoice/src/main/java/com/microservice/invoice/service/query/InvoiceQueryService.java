package com.microservice.invoice.service.query;

import com.microservice.invoice.dto.InvoiceGetDTO;
import com.microservice.invoice.dto.TotalMonthSalesGetDTO;
import com.microservice.invoice.dto.TotalSalesGetDTO;
import com.microservice.invoice.dto.TotalWeekSalesGetDTO;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface InvoiceQueryService {
    List<InvoiceGetDTO> findAll();
    List<InvoiceGetDTO> findByClientId(Integer id);
    InvoiceGetDTO findById(Integer id);
    TotalSalesGetDTO findTotalSales();
    List<TotalWeekSalesGetDTO> findSalesLastWeek() throws ParseException;
    List<TotalMonthSalesGetDTO> findAllMonthSales();


}
