package com.case_study.services.impl;

import com.case_study.models.Division;
import com.case_study.repositories.DivisionRepository;
import com.case_study.services.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return this.divisionRepository.findAll();
    }
}
