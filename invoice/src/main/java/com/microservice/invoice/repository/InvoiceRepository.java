package com.microservice.invoice.repository;

import com.microservice.invoice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    @Query(value = "SELECT SUM(total) FROM invoice WHERE date = (CURRENT_DATE - INTERVAL '1 day')", nativeQuery=true)
    Double findTodaySales();

    @Query(value = "SELECT SUM(total) FROM invoice WHERE EXTRACT(MONTH FROM date) = :month", nativeQuery=true)
    Double findMonthSales(Integer month);

    @Query(value = "SELECT DATE_PART('month',v.date) AS month,\n" +
            "       SUM(v.total) AS Total\n" +
            "FROM public.invoice v\n" +
            "WHERE DATE_PART('year',v.date) = DATE_PART('year',NOW())\n" +
            "GROUP BY month\n" +
            "ORDER BY month ASC;", nativeQuery=true)
    Object[][] findAllMonthSales();


    @Query(value = "SELECT date_trunc('day', date) as fecha, SUM(total) as valor_total\n" +
            "FROM invoice\n" +
            "WHERE date >= NOW() - INTERVAL '15 days'\n" +
            "GROUP BY fecha\n" +
            "ORDER BY fecha DESC", nativeQuery = true)
    List<?> findSalesLastWeek();

    List<Invoice> findByClientId(Integer id);

}
