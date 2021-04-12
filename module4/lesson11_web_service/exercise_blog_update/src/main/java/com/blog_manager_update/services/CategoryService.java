package com.blog_manager_update.services;

import com.blog_manager_update.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    Category findById(Integer id);

    void save(Category category);

    void deleteById(Integer id);
}
