package com.exam.services;

import com.exam.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);
}
