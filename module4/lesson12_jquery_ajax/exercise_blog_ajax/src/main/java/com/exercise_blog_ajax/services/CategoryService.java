package com.exercise_blog_ajax.services;

import com.exercise_blog_ajax.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    Category findById(Integer id);

    void save(Category category);

    void deleteById(Integer id);
}
