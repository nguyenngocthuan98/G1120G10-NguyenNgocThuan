package com.practice_smartphone_mng.services.impl;

import com.practice_smartphone_mng.models.Smartphone;
import com.practice_smartphone_mng.repositories.SmartphoneRepository;
import com.practice_smartphone_mng.services.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {
    @Autowired
    SmartphoneRepository smartphoneRepository;

    @Override
    public Page<Smartphone> findAll(Pageable pageable) {
        return this.smartphoneRepository.findAll(pageable);
    }

    @Override
    public Smartphone findById(int id) {
        return this.smartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Smartphone smartphone) {
        this.smartphoneRepository.save(smartphone);
    }

    @Override
    public void deleteById(int id) {
        this.smartphoneRepository.deleteById(id);
    }
}
