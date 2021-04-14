package com.exercise_cusmomer_manager.service.impl;

import com.exercise_cusmomer_manager.model.Province;
import com.exercise_cusmomer_manager.repository.ProvinceRepository;
import com.exercise_cusmomer_manager.service.ProvinceService;
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
