package com.practice_i18n_blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String getPage(){
        return "/index";
    }

    @GetMapping("/page2")
    public String getPage2(){
        return "/index2";
    }
}
