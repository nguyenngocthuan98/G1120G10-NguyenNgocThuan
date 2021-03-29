package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @GetMapping("/viewpager") // như một action
    public String greeting(@RequestParam String name, Model model) {
        model.addAttribute("ten", name);
        return "/show"; // return đến về đến file view jsp
    }
}
