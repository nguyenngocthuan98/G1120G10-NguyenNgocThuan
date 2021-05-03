package com.exam.services;

import com.exam.models.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Page<Orders> findAll(Pageable pageable);

    Orders findById(Integer id);

    void save(Orders orders);
}
