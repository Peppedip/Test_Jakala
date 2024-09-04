package com.test_Jakala.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.test_Jakala.demo.model.Order;
import com.test_Jakala.demo.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody @Valid Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable Long userId, Pageable pageable) {
        return orderService.getOrdersByUserId(userId, pageable);
    }

    @GetMapping("/user/{userId}/total-cost")
    public Double getTotalCostByUserId(@PathVariable Long userId) {
        return orderService.getTotalCostByUserId(userId);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody @Valid Order orderDetails) {
        return orderService.updateOrder(id, orderDetails);
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

}

