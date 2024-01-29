package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {


    @Test
    @DisplayName("Test add empty string returns zero")
    void testAddEmptyStringReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        assertEquals(0, result);

    }

    @Test
    @DisplayName("Test add single number should return same number")
    void testAddSingleNumberShouldReturnSameNumber() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("5");
        assertEquals(5,result);


    }
    @Test
    @DisplayName("Test double numbers returns sum")
    void testDoubleNumbersReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("9,11");
        assertEquals(20,result);
    }

}
