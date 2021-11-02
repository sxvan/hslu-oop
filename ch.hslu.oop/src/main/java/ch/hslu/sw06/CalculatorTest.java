package ch.hslu.sw06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void addition_oneAndOne_returnsTwo() {
        int number1 = 1;
        int number2 = 1;
        var calculator = new Calculator();

        int result = calculator.addition(number1, number2);

        assertEquals(2, result);
    }

    @Test
    public void addition_oneAndNegativeTwo_returnsNegativeOne() {
        int number1 = 1;
        int number2 = -2;
        var calculator = new Calculator();

        int result = calculator.addition(number1, number2);

        assertEquals(-1, result);
    }

    @Test
    public void addition_negativeOneAndNegativeTwo_returnsNegativeThree() {
        int number1 = -1;
        int number2 = -2;
        var calculator = new Calculator();

        int result = calculator.addition(number1, number2);

        assertEquals(-3, result);
    }
}