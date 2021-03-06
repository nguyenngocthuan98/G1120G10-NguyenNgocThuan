package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void create(Product customer);

    Product findById(int id);

    void update(int id, Product customer);

    void delete(int id);

    List<String> getTypeProduct();
}
