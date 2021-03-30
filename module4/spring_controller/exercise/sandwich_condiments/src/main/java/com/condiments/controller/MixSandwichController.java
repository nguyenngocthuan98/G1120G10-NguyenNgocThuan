package com.condiments.controller;

import com.condiments.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MixSandwichController {
    @Autowired
    SandwichService sandwichService;

    @PostMapping("/mix")
    public String mixSandwich(@RequestParam(value = "condiment", defaultValue = "Sandwich with nothing") String[] condiment, Model model) {
        String resultSandwich = "";
        List<String> stringList = this.sandwichService.getListCondiment(condiment);
        model.addAttribute("stringList", stringList);
        return "index";
    }

    @GetMapping("/")
    public String getMixMenu() {
        return "mix_sandwich";
    }
}
