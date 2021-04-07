package com.blog.exercise_upgrade_blog.services;

import com.blog.exercise_upgrade_blog.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    Category findById(Integer id);

    void save(Category category);

    void deleteById(Integer id);
}
