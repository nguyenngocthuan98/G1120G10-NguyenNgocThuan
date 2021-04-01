package com.customer.service.impl;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public void create(Customer customer) {
        this.customerRepository.create(customer);
    }

    @Override
    public Customer findById(int id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        this.customerRepository.update(id, customer);
    }

    @Override
    public void delete(int id) {
        this.customerRepository.delete(id);
    }
}
