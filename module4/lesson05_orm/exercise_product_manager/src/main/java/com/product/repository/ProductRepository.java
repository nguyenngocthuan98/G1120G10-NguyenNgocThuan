package com.product.repository;

import com.product.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void create(Product product);

    Product findById(long id);

    void delete(long id);
}
