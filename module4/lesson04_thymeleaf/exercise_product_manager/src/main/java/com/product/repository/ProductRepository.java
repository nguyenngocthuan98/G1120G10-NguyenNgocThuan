package com.product.repository;

import com.product.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void create(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void delete(int id);

    List<String> getTypeProduct();
}
