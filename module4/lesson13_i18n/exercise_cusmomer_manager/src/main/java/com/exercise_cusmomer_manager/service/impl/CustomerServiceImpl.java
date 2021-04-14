package com.exercise_cusmomer_manager.service.impl;

import com.exercise_cusmomer_manager.model.Customer;
import com.exercise_cusmomer_manager.repository.CustomerRepository;
import com.exercise_cusmomer_manager.service.CustomerService;
import com.exercise_cusmomer_manager.service.exception.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) throws DuplicateEmailException {
        try {
            repository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }

    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Customer> findAllByProvinceName(String name) {
        return repository.findAllByProvinceName(name);
    }

    @Override
    public Page<Customer> findAllByNameContaining(String name, Pageable pageable) {
        return repository.findAllByNameContaining(name, pageable);
    }


}
