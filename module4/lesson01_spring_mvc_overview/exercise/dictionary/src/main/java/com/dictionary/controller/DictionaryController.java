package com.dictionary.controller;

import com.dictionary.repository.DictionaryRepository;
import com.dictionary.repository.DictionaryRepositoryImpl;
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

//    List<String> listKeys = this.dictionaryService.getAllKey(); // BUG

    /* Can't use getAllKey with
        List<String> listKeys = dictionaryService.getAllKey();
        because dictionaryService.getKey() is null
        so I use the way below (lines 28, 29)
    */
    DictionaryRepository dictionaryRepository = new DictionaryRepositoryImpl();
    List<String> listKeys = dictionaryRepository.getAllKey();

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String inputValue, Model model) {
        model.addAttribute("inputValue", inputValue);
        String result = this.dictionaryService.translate(inputValue);

        if (!result.equals("")) {
            model.addAttribute("outputValue", result);
        } else {
            model.addAttribute("mess", "Not found in out list! Try again");
            model.addAttribute("listKey", listKeys);
        }
        return "index";
    }
}
