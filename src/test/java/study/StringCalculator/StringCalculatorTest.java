package study.StringCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    public void testValidCalculator() {
        assertEquals(10, StringCalculator.calculate("2 + 3 * 4 / 2"));
    }

    @Test
    public void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.calculate("2 +"));
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> StringCalculator.calculate("2 / 0"));
    }

    @Test
    public void testInvalidOperator() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.calculate("2 ^ 3"));
    }
}
