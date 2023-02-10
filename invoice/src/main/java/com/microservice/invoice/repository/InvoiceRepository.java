package com.microservice.invoice.repository;

import com.microservice.invoice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    @Query(value = "SELECT SUM(total) FROM invoice WHERE date = :today", nativeQuery=true)
    Double findTodaySales(LocalDate today);

    @Query(value = "SELECT SUM(total) FROM invoice WHERE EXTRACT(MONTH FROM date) = :month", nativeQuery=true)
    Double findMonthSales(Integer month);

    List<Invoice> findByClientId(Integer id);

}
