package com.calculator.service.Impl;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements com.calculator.service.CalculatorService {
    @Override
    public double calculate(String firstNumber, String secondNumber, String operator) {
        double result = 0;
        double firstNum = Double.parseDouble(firstNumber);
        double secondNum = Double.parseDouble(secondNumber);
        switch (operator) {
            case "addition":
                result = firstNum + secondNum;
                break;
            case "subtraction":
                result = firstNum - secondNum;
                break;
            case "multiplication":
                result = firstNum * secondNum;
                break;
            case "division":
                result = firstNum / secondNum;
                break;
        }
        return result;
    }

    @Override
    public String changeOperators(String operator) {
        String operators;
        switch (operator) {
            case "addition":
                operators = "+";
                break;
            case "subtraction":
                operators = "-";
                break;
            case "multiplication":
                operators = "x";
                break;
            case "division":
                operators = "/";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        return operators;
    }
}
