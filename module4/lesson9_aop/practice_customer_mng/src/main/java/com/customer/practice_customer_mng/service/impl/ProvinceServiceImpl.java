package com.customer.practice_customer_mng.service.impl;

import com.customer.practice_customer_mng.model.Province;
import com.customer.practice_customer_mng.repository.ProvinceRepository;
import com.customer.practice_customer_mng.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceRepository repository;

    @Override
    public List<Province> findAll() {
        return repository.findAll();
    }
}
