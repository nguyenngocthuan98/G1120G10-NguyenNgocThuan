package com.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam double firstNumber,
                            @RequestParam double secondNumber,
                            @RequestParam String operator,
                            Model model) {
        double result = 0;
        if (secondNumber == 0) {
            operator = "/";
            model.addAttribute("exceptionDivisionForZero", "Not divided by 0");
            model.addAttribute("operator", operator);
            model.addAttribute("firstNumber", firstNumber);
            model.addAttribute("secondNumber", secondNumber);
        } else {
            switch (operator) {
                case "addition":
                    result = firstNumber + secondNumber;
                    operator = "+";
                    break;
                case "subtraction":
                    result = firstNumber - secondNumber;
                    operator = "-";
                    break;
                case "multiplication":
                    result = firstNumber * secondNumber;
                    operator = "x";
                    break;
                case "division":
                    result = firstNumber / secondNumber;
                    operator = "/";
                    break;
            }
            model.addAttribute("result", result);
            model.addAttribute("operator", operator);
            model.addAttribute("firstNumber", firstNumber);
            model.addAttribute("secondNumber", secondNumber);
        }
        return "index";
    }
}
