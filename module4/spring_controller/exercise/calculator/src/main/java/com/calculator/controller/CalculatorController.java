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
        double result = 0;
        String operators = "";
        if (Double.parseDouble(secondNumber) == 0 && operator.equals("division")) {
            model.addAttribute("operator", operator);
            model.addAttribute("exceptionDivisionForZero", "Not divided by 0");
        } else {
            result = this.calculatorService.calculate(firstNumber, secondNumber, operator);
            operators = this.calculatorService.changeOperators(operator);
        }
        model.addAttribute("result", result);
        model.addAttribute("operator",operators);
        model.addAttribute("firstNumber",firstNumber);
        model.addAttribute("secondNumber",secondNumber);
        return"index";
    }
}
