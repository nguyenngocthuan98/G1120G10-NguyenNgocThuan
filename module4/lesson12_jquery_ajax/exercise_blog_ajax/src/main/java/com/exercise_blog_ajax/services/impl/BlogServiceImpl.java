package com.exercise_blog_ajax.services.impl;

import com.exercise_blog_ajax.models.Blog;
import com.exercise_blog_ajax.repositories.BlogRepository;
import com.exercise_blog_ajax.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null) {
            blog.setDateCreated(new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date()));
        }
        blogRepository.save(blog);
    }

    @Override
    public void deleteById(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByTitle(String searchText, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(searchText, pageable);
    }

    @Override
    public List<Blog> findAllByTitle(String searchText) {
        return blogRepository.findAllByTitleContaining(searchText);
    }
}
