package com.exercise_blog_ajax.controllers;

import com.exercise_blog_ajax.models.Blog;
import com.exercise_blog_ajax.services.BlogServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @PostMapping("/createBlog")
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog, UriComponentsBuilder uriComponentsBuilder) {
        blogServiceAPI.save(blog);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/blogs/{id}").buildAndExpand(blog.getId()).toUri());
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/updateBlog")
    public ResponseEntity<Blog> updateBlog(@RequestParam Integer id, @RequestBody Blog blog) {
        Blog currentBlog = blogServiceAPI.findById(id);
        if (currentBlog == null) {
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        } else {
            currentBlog.setId(blog.getId());
            currentBlog.setAuthorName(blog.getAuthorName());
            currentBlog.setCategory(blog.getCategory());
            currentBlog.setContent(blog.getContent());
            currentBlog.setDateCreated(blog.getDateCreated());
            currentBlog.setTitle(blog.getTitle());
            currentBlog.setDescription(blog.getDescription());

            blogServiceAPI.save(currentBlog);
            return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteBlog")
    public ResponseEntity<Blog> deleteBlog(@RequestParam Integer id) {
        if (blogServiceAPI.findById(id) == null) {
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        } else {
            blogServiceAPI.deleteById(id);
            return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
        }
    }
}
