package com.microservice.order.repository;

import com.microservice.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByIdClient(Integer id);

    List<Order> findByDeliveryStateId(Integer id);

    List<Order> findByOrderStateId(Integer id);

    @Query(value = "SELECT SUM(order_details.amount) FROM krugorders, order_details WHERE (krugorders.id = order_details.order_id) AND krugorders.date > DATE_SUB(CURDATE(),INTERVAL 1 DAY)", nativeQuery=true)
    Integer productsSoldOnDay();


}
