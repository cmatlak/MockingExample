package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

private StringCalculator  calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("Test add empty string returns zero")
    void testAddEmptyStringReturnsZero() {
        int result = calculator.add("");
        assertEquals(0, result);

    }

    @Test
    @DisplayName("Test add single number should return same number")
    void testAddSingleNumberShouldReturnSameNumber() {

        int result = calculator.add("5");
        assertEquals(5,result);


    }
    @Test
    @DisplayName("Test double numbers returns sum")
    void testDoubleNumbersReturnsSum() {
        int result = calculator.add("10,10");
        assertEquals(20,result);
    }

    @Test
    @DisplayName("Test multiple numbers return sum")
    void testMultipleNumbersReturnSum() {
        int result = calculator.add("1,2,3,4,5,6");
        assertEquals(21,result);
    }

    @Test
    @DisplayName("Test add with custom delimiter")
    void testAddWithCustomDelimiter() {
        int result = calculator.add("//;\n1;2");
        assertEquals(3,result);
    }

    @Test
    @DisplayName("Test add with default delimiter")
    void testAddWithDefaultDelimiter() {
        int result = calculator.add("1\n2\n3,4");
        assertEquals(10,result);
    }

    @Test
    @DisplayName("Test with negatives")
    void testWithNegatives() {
        String numbers = "1,-3,4,-10";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()-> {
            calculator.add(numbers);
        });
        assertEquals("Negatives not allowed [-3, -10]", exception.getMessage());
    }

    @Test
    @DisplayName("Test add larger than thousand")
    void testAddLargerThanThousand() {
        int result = calculator.add("1000,1");
        assertEquals(1,result);
    }

    @Test
    @DisplayName("Test with variable length of delimiter")
    void testWithVariableLengthOfDelimiter() {
        int result = calculator.add("//[***]\n\n\n1**2***,,,,3");
        assertEquals(6,result);
    }

    @Test
    @DisplayName("Test with multiple delimiters")
    void testWithMultipleDelimiters() {
        int result = calculator.add("//[*][%]\n1*2%3");
        assertEquals(6,result);
    }
@Test
@DisplayName("Testing with multiple delimiters of varying length")
void testingWithMultipleDelimitersOfVaryingLength() {
        int result = calculator.add("//[***][%%%]\n1***3%%%%2");
        assertEquals(6,result);
}

}
