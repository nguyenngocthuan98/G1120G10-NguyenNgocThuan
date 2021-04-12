package com.blog_manager_update.services;

import com.blog_manager_update.models.Category;

import java.util.List;

public interface CategoryServiceAPI {
    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void deleteById(Integer id);
}
