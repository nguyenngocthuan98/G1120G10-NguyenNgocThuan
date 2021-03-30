package com.condiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class MixSandwichController {

    @PostMapping("/mix")
    public String mixSandwich(@RequestParam String[] condiment, Model model) {
        List<String> stringList = Arrays.asList(condiment);
        model.addAttribute("stringList", stringList);
        return "index";
    }

    @GetMapping("/")
    public String getMixMenu() {
        return "mix_sandwich";
    }
}
