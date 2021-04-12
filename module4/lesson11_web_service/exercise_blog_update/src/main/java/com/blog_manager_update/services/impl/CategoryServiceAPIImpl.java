package com.blog_manager_update.services.impl;

import com.blog_manager_update.models.Category;
import com.blog_manager_update.repositories.CategoryRepositoryAPI;
import com.blog_manager_update.services.CategoryServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceAPIImpl implements CategoryServiceAPI {
    @Autowired
    CategoryRepositoryAPI categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }
}
