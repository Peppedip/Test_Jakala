package com.test_Jakala.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.test_Jakala.demo.model.Order;
import com.test_Jakala.demo.repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found"));
    }

    public List<Order> getOrdersByUserId(Long userId, Pageable pageable) {
        return orderRepository.findByUserIdOrderByOrderDateDesc(userId);
    }

    public Double getTotalCostByUserId(Long userId) {
        return orderRepository.sumTotalCostByUserId(userId);
    }

	public Order updateOrder(Long id, @Valid Order orderDetails) {
		 Order order = getOrderById(id); 
	        order.setTotalCost(orderDetails.getTotalCost());
	        order.setOrderDate(orderDetails.getOrderDate());
	        return orderRepository.save(order);
	}

	public void deleteOrder(Long id) {
		Order order = getOrderById(id);
        orderRepository.delete(order);
		
	}
}
