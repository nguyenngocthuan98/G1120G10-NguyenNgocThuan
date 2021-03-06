package com.case_study.services;

import com.case_study.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;


public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Employee findById(Integer id);

    void save(Employee employee);

    void deleteById(Integer id);

    Page<Employee> findAllByEmployeeNameContaining(String searchText, Pageable pageable);

    void checkEmployeeId(Employee customer, Errors errors);
}
