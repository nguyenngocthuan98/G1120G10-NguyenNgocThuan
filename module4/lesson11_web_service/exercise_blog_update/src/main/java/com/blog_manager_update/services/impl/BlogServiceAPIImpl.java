package com.blog_manager_update.services.impl;

import com.blog_manager_update.models.Blog;
import com.blog_manager_update.repositories.BlogRepositoryAPI;
import com.blog_manager_update.services.BlogServiceAPI;
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
