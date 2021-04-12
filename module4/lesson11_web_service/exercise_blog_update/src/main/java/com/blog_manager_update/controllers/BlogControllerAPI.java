package com.blog_manager_update.controllers;

import com.blog_manager_update.models.Blog;
import com.blog_manager_update.services.BlogServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogControllerAPI {
    @Autowired
    private BlogServiceAPI blogServiceAPI;

    @GetMapping("/listBlogsAPI")
    public ResponseEntity<List<Blog>> listBlogs() {
        if (blogServiceAPI.findAll() == null) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Blog>>(blogServiceAPI.findAll(), HttpStatus.OK);
    }

    @GetMapping("/viewDetailBlogAPI")
    public ResponseEntity<Blog> viewDetailBlog(@RequestParam Integer id) {
        return new ResponseEntity<Blog>(blogServiceAPI.findById(id), HttpStatus.OK);
    }
}
