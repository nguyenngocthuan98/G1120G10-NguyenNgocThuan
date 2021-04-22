package com.case_study.services.impl;

import com.case_study.models.Contract;
import com.case_study.repositories.ContractRepository;
import com.case_study.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return this.contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        this.contractRepository.save(contract);
    }

    @Override
    public Double totalMoney(Contract contract) {
        int totalDay = 0;
        try {
            Date startDate = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").parse(contract.getContractStartDate());
            Date endDate = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").parse(contract.getContractEndDate());
            totalDay = (int) TimeUnit.DAYS.convert(endDate.getTime() - startDate.getTime(), TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double cost = contract.getService().getServiceCost();

        return totalDay * cost;
    }
}
