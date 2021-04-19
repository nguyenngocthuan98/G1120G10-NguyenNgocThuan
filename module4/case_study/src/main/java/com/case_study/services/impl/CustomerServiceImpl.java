package com.case_study.services.impl;

import com.case_study.models.Customer;
import com.case_study.repositories.CustomerRepository;
import com.case_study.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllByCustomerName(String searchText, org.springframework.data.domain.Pageable pageable) {
        return customerRepository.findAllByCustomerName(searchText,pageable);
    }
}
