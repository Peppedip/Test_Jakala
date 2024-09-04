package com.test_Jakala.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test_Jakala.demo.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserIdOrderByOrderDateDesc(Long userId);
    @Query("SELECT SUM(o.totalCost) FROM Order o WHERE o.user.id = :userId")
    Double sumTotalCostByUserId(Long userId);
}

