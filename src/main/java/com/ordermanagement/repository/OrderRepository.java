package com.ordermanagement.repository;

import com.ordermanagement.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.orderId = ?1")
    Optional<Order> findOrderByOrderId(Long orderId);
}
