package org.example.cart_management.service;

import org.example.cart_management.entity.Order;
import org.example.cart_management.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{
    @Autowired
    private IOrderRepository orderRepository;
    
    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
