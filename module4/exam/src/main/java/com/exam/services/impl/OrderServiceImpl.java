package com.exam.services.impl;

import com.exam.models.Orders;
import com.exam.repositories.OrderRepository;
import com.exam.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Page<Orders> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Orders findById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Orders orders) {
        this.orderRepository.save(orders);
    }
}
