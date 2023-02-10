package com.microservice.invoice.repository;

import com.microservice.invoice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    @Query(value = "SELECT SUM(total) FROM invoice WHERE date = :today", nativeQuery=true)
    Double findTodaySales(LocalDate today);

    @Query(value = "SELECT SUM(total) FROM invoice WHERE EXTRACT(MONTH FROM date) = :month", nativeQuery=true)
    Double findMonthSales(Integer month);

    @Query(value = "SELECT date_trunc('day', date) as fecha, SUM(total) as valor_total\n" +
            "FROM invoice\n" +
            "WHERE date >= NOW() - INTERVAL '15 days'\n" +
            "GROUP BY fecha\n" +
            "ORDER BY fecha DESC", nativeQuery = true)
    List<?> findSalesLastWeek();

    List<Invoice> findByClientId(Integer id);

}
