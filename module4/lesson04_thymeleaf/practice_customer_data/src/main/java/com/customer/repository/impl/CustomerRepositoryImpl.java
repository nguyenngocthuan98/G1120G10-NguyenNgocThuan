package com.customer.repository.impl;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private static HashMap<Integer, Customer> mapCustomer;

    static {
        mapCustomer = new HashMap<>();
        mapCustomer.put(1, new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        mapCustomer.put(2, new Customer(2, "Bill", "customer2@codegym.vn", "Unknown"));
        mapCustomer.put(3, new Customer(3, "Alex", "cust4omer3@codegym.vn", "ThaiLand"));
        mapCustomer.put(4, new Customer(4, "Adam", "custo2mer@codegym.vn", "Hanoi"));
        mapCustomer.put(5, new Customer(5, "Sophia", "cus5tomer@codegym.vn", "Laos"));
        mapCustomer.put(6, new Customer(6, "Rose", "costom23er@codegym.vn", "Unknown"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(mapCustomer.values());
    }

    @Override
    public void create(Customer customer) {
        List<Customer> listCustomer = findAll();
        int id = listCustomer.get(listCustomer.size() - 1).getId() + 1;
        customer.setId(id);
        mapCustomer.put(id, customer);
    }

    @Override
    public Customer findById(int id) {
        return mapCustomer.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        mapCustomer.put(id, customer);
    }

    @Override
    public void delete(int id) {
        mapCustomer.remove(id);
    }
}
