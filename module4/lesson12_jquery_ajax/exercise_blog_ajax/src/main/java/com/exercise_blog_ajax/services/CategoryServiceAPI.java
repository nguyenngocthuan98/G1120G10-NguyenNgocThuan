package com.exercise_blog_ajax.services;

import com.exercise_blog_ajax.models.Category;

import java.util.List;

public interface CategoryServiceAPI {
    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void deleteById(Integer id);
}
