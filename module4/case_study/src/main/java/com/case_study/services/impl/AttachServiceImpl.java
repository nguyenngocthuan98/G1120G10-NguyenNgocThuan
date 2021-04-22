package com.case_study.services.impl;

import com.case_study.repositories.AttachServiceRepository;
import com.case_study.services.AttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl implements AttachService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public List<com.case_study.models.AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
