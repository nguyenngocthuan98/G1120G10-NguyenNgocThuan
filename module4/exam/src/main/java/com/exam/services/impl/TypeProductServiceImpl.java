package com.exam.services.impl;

import com.exam.models.TypeProduct;
import com.exam.repositories.TypeProductRepository;
import com.exam.services.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductServiceImpl implements TypeProductService {
    @Autowired
    private TypeProductRepository typeProductRepository;

    @Override
    public List<TypeProduct> findAll() {
        return typeProductRepository.findAll();
    }

    @Override
    public TypeProduct findById(Integer id) {
        return typeProductRepository.findById(id).orElse(null);
    }
}
