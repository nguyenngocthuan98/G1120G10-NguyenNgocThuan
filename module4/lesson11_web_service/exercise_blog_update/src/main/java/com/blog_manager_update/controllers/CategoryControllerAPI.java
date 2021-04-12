package com.blog_manager_update.controllers;

import com.blog_manager_update.models.Category;
import com.blog_manager_update.services.CategoryServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CategoryControllerAPI {
    @Autowired
    private CategoryServiceAPI categoryServiceAPI;

    @GetMapping("/listCategoriesAPI")
    public ResponseEntity<List<Category>> listCategories() {
        if (categoryServiceAPI.findAll() == null) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categoryServiceAPI.findAll(), HttpStatus.OK);
    }

    @GetMapping("/viewDetailCategoryAPI")
    public ResponseEntity<Category> viewDetailCategory(@RequestParam Integer id) {
        return new ResponseEntity<Category>(categoryServiceAPI.findById(id), HttpStatus.OK);
    }

    @PostMapping("/createCategory")
    public ResponseEntity<Void> createCategory(@RequestBody Category category, UriComponentsBuilder uriComponentsBuilder) {
        categoryServiceAPI.save(category);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/categories/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/updateCategory")
    public ResponseEntity<Category> updateCategory(@RequestParam Integer id, @RequestBody Category category) {
        Category currentCategory = categoryServiceAPI.findById(id);
        if (currentCategory == null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        } else {
            currentCategory.setId(category.getId());
            currentCategory.setName(category.getName());
            currentCategory.setBlog(category.getBlog());

            categoryServiceAPI.save(currentCategory);
            return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteCategory")
    public ResponseEntity<Category> deleteCategory(@RequestParam Integer id) {
        if (categoryServiceAPI.findById(id) == null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        } else {
            categoryServiceAPI.deleteById(id);
            return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
        }
    }
}
