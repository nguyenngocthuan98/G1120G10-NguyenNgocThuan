package com.case_study.services;

import com.case_study.models.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();

    void save(Contract contract);

    Double totalMoney(Contract contract);

    Contract findById(Integer id);

    Page<Contract> customersUsing(String date, Pageable pageable);
}
