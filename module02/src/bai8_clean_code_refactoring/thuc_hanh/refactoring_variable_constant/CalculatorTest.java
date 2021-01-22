package bai8_clean_code_refactoring.thuc_hanh.refactoring_variable_constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest extends Calculator {
    @Test
    @DisplayName("Testing addition")
    void testCalculateAdd() {
        int first_number = 1;
        int second_number = 1;
        int expected = 2;

        int result = Calculator.calculate(first_number, second_number, ADDITION);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing subtraction")
    void testCalculateSub() {
        int first_number = 2;
        int second_number = 1;
        int expected = 1;

        int result = Calculator.calculate(first_number, second_number, SUBTRACTION);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing multiplication")
    void testCalculateMul() {
        int first_number = 2;
        int second_number = 2;
        int expected = 4;

        int result = Calculator.calculate(first_number, second_number, MULTIPLICATION);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division")
    void testCalculateDiv() {
        int first_number = 6;
        int second_number = 3;
        int expected = 2;

        int result = Calculator.calculate(first_number, second_number, DIVISION);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division by zero")
    void testCalculateDivByZero() {
        int first_number = 2;
        int second_number = 0;

        assertThrows(RuntimeException.class,
                () -> Calculator.calculate(first_number, second_number, DIVISION));
    }

    @Test
    @DisplayName("Testing wrong operator")
    void testCalculateWrongOperator() {
        int first_number = 2;
        int second_number = 0;

        assertThrows(RuntimeException.class,
                () -> Calculator.calculate(first_number, second_number, EQUAL));
    }
}
