package com.blog_manager_update.services;

import com.blog_manager_update.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(int id);

    void save(Blog blog);

    void deleteById(int id);

    Page<Blog> findAllByTitle(String searchText, Pageable pageable);
}
