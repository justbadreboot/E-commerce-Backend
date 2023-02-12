package com.microservice.invoice.service.query;

import com.microservice.invoice.dto.InvoiceGetDTO;
import com.microservice.invoice.dto.TotalMonthSalesGetDTO;
import com.microservice.invoice.dto.TotalSalesGetDTO;
import com.microservice.invoice.entity.Invoice;
import com.microservice.invoice.mapper.InvoiceMapper;
import com.microservice.invoice.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
@AllArgsConstructor
public class InvoiceQueryServiceImpl implements InvoiceQueryService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;


    private static Double convertToDouble(Object o) {
        String stringToConvert = String.valueOf(o);
        return Double.parseDouble(stringToConvert);
    }

    private static Integer convertToInteger(Object o) {
        String stringToConvert = String.valueOf(o);
        return (int)Double.parseDouble(stringToConvert);
    }

    @Override
    public List<InvoiceGetDTO> findAll() {
        return invoiceMapper.toInvoicesDto(invoiceRepository.findAll());
    }

    @Override
    public List<InvoiceGetDTO> findByClientId(Integer id) {
        return invoiceMapper.toInvoicesDto(invoiceRepository.findByClientId(id));
    }

    @Override
    public InvoiceGetDTO findById(Integer id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        return invoice.map(value -> invoiceMapper.toInvoiceDto(value)).orElse(null);
    }

    @Override
    public TotalSalesGetDTO findTotalSales() {
        Double today = invoiceRepository.findTodaySales();
        Double month = invoiceRepository.findMonthSales(LocalDate.now().getMonthValue());
        return new TotalSalesGetDTO(today == null ? 0 : today, month == null ? 0: month);
    }

    @Override
    public List<?> findSalesLastWeek() {
        return invoiceRepository.findSalesLastWeek();
    }

    @Override
    public List<TotalMonthSalesGetDTO> findAllMonthSales() {
        Object[][] dataRepository =  invoiceRepository.findAllMonthSales();
        List<TotalMonthSalesGetDTO> salesByMonthBase = new ArrayList<>();
        for(int i = 1; i<=12;i++){
            salesByMonthBase.add(new TotalMonthSalesGetDTO(i,0.0));
        }
        List<TotalMonthSalesGetDTO> salesByMonth = new ArrayList<>();

        Arrays.stream(dataRepository).forEach(row->{
            salesByMonth.add(new TotalMonthSalesGetDTO(convertToInteger(row[0]),convertToDouble(row[1])));
        });

        if(salesByMonth.isEmpty()){
            return salesByMonthBase;
        }

        for (TotalMonthSalesGetDTO month: salesByMonth) {
            for (TotalMonthSalesGetDTO monthBase: salesByMonthBase) {
                if(month.getMonth() == monthBase.getMonth()){
                    salesByMonthBase.set(monthBase.getMonth()-1,month);
                    break;
                }
            }
        }
        return salesByMonthBase;
    }


}
