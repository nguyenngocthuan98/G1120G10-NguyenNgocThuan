package com.product.service.impl;

import com.product.model.Product;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository customerRepository;

    @Override
    public List<Product> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public void create(Product customer) {
        this.customerRepository.create(customer);
    }

    @Override
    public Product findById(int id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public void update(int id, Product customer) {
        this.customerRepository.update(id, customer);
    }

    @Override
    public void delete(int id) {
        this.customerRepository.delete(id);
    }

    @Override
    public List<String> getTypeProduct() {
        return this.customerRepository.getTypeProduct();
    }
}
