package com.case_study.services.impl;

import com.case_study.models.RentType;
import com.case_study.repositories.RentTypeRepository;
import com.case_study.services.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return this.rentTypeRepository.findAll();
    }
}
