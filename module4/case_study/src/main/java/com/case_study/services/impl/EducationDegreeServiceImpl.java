package com.case_study.services.impl;

import com.case_study.models.EducationDegree;
import com.case_study.repositories.EducationDegreeRepository;
import com.case_study.services.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return this.educationDegreeRepository.findAll();
    }
}
