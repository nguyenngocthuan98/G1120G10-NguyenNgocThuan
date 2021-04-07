package com.blog.exercise_upgrade_blog.services;

import com.blog.exercise_upgrade_blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(int id);

    void save(Blog blog);

    void deleteById(int id);

    Page<Blog> findAllByTitle(String searchText, Pageable pageable);
}
