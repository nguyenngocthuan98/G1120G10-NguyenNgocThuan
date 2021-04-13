package com.exercise_blog_ajax.services;

import com.exercise_blog_ajax.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(int id);

    void save(Blog blog);

    void deleteById(int id);

    Page<Blog> findAllByTitle(String searchText, Pageable pageable);
}
