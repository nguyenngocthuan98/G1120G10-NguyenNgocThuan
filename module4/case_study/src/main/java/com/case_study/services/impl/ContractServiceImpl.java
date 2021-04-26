package com.case_study.services.impl;

import com.case_study.models.Contract;
import com.case_study.models.ContractDetail;
import com.case_study.repositories.ContractRepository;
import com.case_study.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
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
        double totalPrice = 0;

        try {
            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getContractStartDate());
            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getContractEndDate());
            totalDay = (int) TimeUnit.DAYS.convert(endDate.getTime() - startDate.getTime(), TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (totalDay == 0) {
            totalDay = 1; //if contract created, day at least = 1
        }
        double cost = Double.parseDouble(contract.getService().getServiceCost());
        totalPrice = totalDay * cost;

        if (contract.getContractId() != null) {
            Set<ContractDetail> contractDetailSet = contract.getContractDetailSet();
            // if contractDetail of contract not empty, get totalPrice += (all attach service cost * quantity)
            if (!contractDetailSet.isEmpty()) {
                for (ContractDetail contractDetail : contractDetailSet) {
                    totalPrice += contractDetail.getAttachService().getAttachServiceCost() *
                            Integer.parseInt(contractDetail.getQuantity());
                }
            }
        }
        return totalPrice;
    }

    @Override
    public Contract findById(Integer id) {
        return this.contractRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Contract> customersUsing(String date, Pageable pageable) {
        return contractRepository.customersUsing(date, pageable);
    }
}
