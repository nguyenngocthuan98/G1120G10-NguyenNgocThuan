package com.exercise_blog_ajax.services;

import com.exercise_blog_ajax.models.Blog;

import java.util.List;

public interface BlogServiceAPI {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void deleteById(int id);

    List<Blog> findAllByTitle(String searchText);
}
