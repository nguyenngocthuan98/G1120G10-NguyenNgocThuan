package com.exercise_blog_ajax.services.impl;

import com.exercise_blog_ajax.models.Blog;
import com.exercise_blog_ajax.repositories.BlogRepositoryAPI;
import com.exercise_blog_ajax.services.BlogServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceAPIImpl implements BlogServiceAPI {
    @Autowired
    BlogRepositoryAPI blogRepository;

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
    public List<Blog> findAllByTitle(String searchText) {
        return blogRepository.findAllByTitleContaining(searchText);
    }
}
