package com.case_study.services;

import com.case_study.models.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);
}
