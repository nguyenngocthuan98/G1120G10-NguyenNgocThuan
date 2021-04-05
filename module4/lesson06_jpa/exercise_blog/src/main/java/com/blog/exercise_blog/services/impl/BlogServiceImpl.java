package com.blog.exercise_blog.services.impl;

import com.blog.exercise_blog.models.Blog;
import com.blog.exercise_blog.repositories.BlogRepository;
import com.blog.exercise_blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteById(int id) {
        blogRepository.deleteById(id);
    }
}
