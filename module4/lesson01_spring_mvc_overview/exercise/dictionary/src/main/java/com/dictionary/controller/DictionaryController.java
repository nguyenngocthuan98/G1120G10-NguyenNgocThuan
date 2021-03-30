package com.dictionary.controller;

import com.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DictionaryController {
    @Autowired
    DictionaryService dictionaryService;

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String inputValue, Model model) {

        String result = this.dictionaryService.translate(inputValue);
        List<String> listKeys = dictionaryService.getAllKey();
        model.addAttribute("inputValue", inputValue);


        if (!result.equals("")) {
            model.addAttribute("outputValue", result);
        } else {
            model.addAttribute("mess", "Not found in out list! Try again");
            model.addAttribute("listKey", listKeys);
        }

        return "index";
    }
}
