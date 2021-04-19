package com.case_study.services;

import com.case_study.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(String id);

    void save(Customer customer);

    void deleteById(String id);

    Page<Customer> findAllByCustomerName(String searchText, Pageable pageable);
}
