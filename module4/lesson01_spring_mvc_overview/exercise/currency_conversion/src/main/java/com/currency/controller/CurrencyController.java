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
    public String currency(@RequestParam int inputValue, Model model) {
        model.addAttribute("inputValue", inputValue);
        int outputValue = 0;
        outputValue = 23000 * inputValue;
        model.addAttribute("outputValue", outputValue);
        return "index";
    }
}
