package com.practice_smartphone_mng.services;

import com.practice_smartphone_mng.models.Smartphone;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface SmartphoneService {
    Page<Smartphone> findAll(Pageable pageable);

    Smartphone findById(int id);

    void save(Smartphone smartphone);

    void deleteById(int id);
}
