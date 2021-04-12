package com.blog_manager_update.controllers;

import com.blog_manager_update.models.Category;
import com.blog_manager_update.services.CategoryServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
