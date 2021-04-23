package com.case_study.services.impl;

import com.case_study.repositories.ServiceRepository;
import com.case_study.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<com.case_study.models.Service> findAll() {
        return this.serviceRepository.findAll();
    }

    @Override
    public com.case_study.models.Service findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(com.case_study.models.Service service) {
        this.serviceRepository.save(service);
    }

    @Override
    public String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    @Override
    public List<com.case_study.models.Service> findWithoutServiceUsing(String date) {
        return this.serviceRepository.findWithoutServiceUsing(date);
    }
}
