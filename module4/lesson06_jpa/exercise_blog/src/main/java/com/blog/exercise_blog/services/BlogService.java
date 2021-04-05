package com.blog.exercise_blog.services;

import com.blog.exercise_blog.models.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void deleteById(int id);
}
