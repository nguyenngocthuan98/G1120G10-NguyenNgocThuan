package com.case_study.services.impl;

import com.case_study.models.Position;
import com.case_study.repositories.PositionRepository;
import com.case_study.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return this.positionRepository.findAll();
    }
}
