package com.case_study.services;

import com.case_study.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;


public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(String id);

    void save(Customer customer);

    void deleteById(String id);

    Page<Customer> findAllByCustomerNameContainingOrCustomerIdContaining(
            String searchText1, String searchText2, Pageable pageable
    );

    void checkCustomerId(Customer customer, Errors errors);
}
