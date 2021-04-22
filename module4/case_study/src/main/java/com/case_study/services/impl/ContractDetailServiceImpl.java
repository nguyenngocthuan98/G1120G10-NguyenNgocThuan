package com.case_study.services.impl;

import com.case_study.models.Contract;
import com.case_study.models.ContractDetail;
import com.case_study.repositories.ContractDetailRepository;
import com.case_study.services.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    ContractDetailRepository contractDetailRepository;


    @Override
    public List<ContractDetail> findAll() {
        return this.contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        this.contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findAllByContract(Contract contract) {
        return this.contractDetailRepository.findAllByContract(contract);
    }
}
