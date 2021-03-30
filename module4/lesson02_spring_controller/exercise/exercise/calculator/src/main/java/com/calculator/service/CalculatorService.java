package com.calculator.service;

public interface CalculatorService {
    double calculate(String firstNumber, String secondNumber, String operator);
    String changeOperators(String operator);
}
