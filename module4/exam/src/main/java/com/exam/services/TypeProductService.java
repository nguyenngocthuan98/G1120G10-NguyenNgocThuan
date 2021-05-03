package com.exam.services;

import com.exam.models.TypeProduct;

import java.util.List;

public interface TypeProductService {
    List<TypeProduct> findAll();

    TypeProduct findById(Integer id);
}
