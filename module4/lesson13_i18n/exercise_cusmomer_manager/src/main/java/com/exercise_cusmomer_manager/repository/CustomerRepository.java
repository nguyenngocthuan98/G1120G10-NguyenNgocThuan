package com.exercise_cusmomer_manager.repository;

import com.exercise_cusmomer_manager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByProvinceName(String name);

    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
