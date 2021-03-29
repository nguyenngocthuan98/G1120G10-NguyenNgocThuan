package com.currency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping("/")
    public String homePage(){
        return "index";
    }

    @PostMapping("/currency")
    public String currency(@RequestParam int input_value, Model model) {
        model.addAttribute("input_value", input_value);
        int output_value = 0;
        output_value = 23000 * input_value;
        model.addAttribute("output_value", output_value);
        return "index";
    }
}
