package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void create(Product product);

    Product findById(int id);

    void delete(int id);

}
