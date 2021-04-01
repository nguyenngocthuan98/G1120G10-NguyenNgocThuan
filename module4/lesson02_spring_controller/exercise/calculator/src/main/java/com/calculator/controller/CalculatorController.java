package com.calculator.controller;

import com.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String calculate(@RequestParam String firstNumber,
                            @RequestParam String secondNumber,
                            @RequestParam String operator,
                            Model model) {
        try {
            model.addAttribute("result", this.calculatorService.calculate(firstNumber, secondNumber, operator));
        } catch (NumberFormatException exceptionNumber) {
            model.addAttribute("exceptionNumber", "Not a number!");
        } catch (ArithmeticException exception) {
            model.addAttribute("exception", exception.getMessage());
        }
        model.addAttribute("operator", this.calculatorService.changeOperators(operator));
        model.addAttribute("firstNumber", firstNumber);
        model.addAttribute("secondNumber", secondNumber);
        return "index";
    }
}
