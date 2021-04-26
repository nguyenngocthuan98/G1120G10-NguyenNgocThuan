package com.case_study.services.impl;

import com.case_study.models.Employee;
import com.case_study.models.User;
import com.case_study.repositories.EmployeeRepository;
import com.case_study.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAllByEmployeeNameContaining(String searchText, Pageable pageable) {
        return employeeRepository.findAllByEmployeeNameContaining(searchText, pageable);
    }

    @Override
    public void checkEmployeeId(Employee employee, Errors errors) {
        if (findById((employee.getEmployeeId())) != null) {
            errors.rejectValue("customerId", "customer.customerId.existed");
        }
    }
}
