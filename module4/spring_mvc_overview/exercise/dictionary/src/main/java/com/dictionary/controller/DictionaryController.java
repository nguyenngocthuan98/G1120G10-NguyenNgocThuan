package com.dictionary.controller;

import com.dictionary.repository.DictionaryRepository;
import com.dictionary.repository.DictionaryRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DictionaryController {
    DictionaryRepository repository = new DictionaryRepositoryImpl();
    List<String> listKeys = repository.getKey();

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String input_value, Model model) {
        model.addAttribute("input_value", input_value);
        String result = this.repository.translate(input_value);

        if (!result.equals("")) {
            model.addAttribute("output_value", result);
        } else {
            model.addAttribute("mess", "Not found in out list! Try again");
            model.addAttribute("listKey", listKeys);
        }
        return "index";
    }
}
