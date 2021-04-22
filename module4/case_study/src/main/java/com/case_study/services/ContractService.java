package com.case_study.services;

import com.case_study.models.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();

    void save(Contract contract);

    Double totalMoney(Contract contract);
}
