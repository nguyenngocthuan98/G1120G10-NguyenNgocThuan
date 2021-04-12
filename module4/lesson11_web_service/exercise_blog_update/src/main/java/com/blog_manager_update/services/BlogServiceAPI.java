package com.blog_manager_update.services;

import com.blog_manager_update.models.Blog;

import java.util.List;

public interface BlogServiceAPI {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void deleteById(int id);

    List<Blog> findAllByTitle(String searchText);
}
