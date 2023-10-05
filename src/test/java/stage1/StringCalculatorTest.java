package stage1;

import org.assertj.core.api.AbstractDoubleAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.Double.NaN;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("덧셈 기능 테스트")
    void addTest() {
        double result1 = stringCalculator.add(4, 5);
        double result2 = stringCalculator.add(0, 0);
        double result3 = stringCalculator.add(-100, -5);
        double result4 = stringCalculator.add(-2, 5);
        double result5 = stringCalculator.add(0.5, 0.9);

        assertThat(result1).isEqualTo(9);
        assertThat(result2).isEqualTo(0);
        assertThat(result3).isEqualTo(-105);
        assertThat(result4).isEqualTo(3);
        assertThat(result5).isEqualTo(1.4);
    }

    @Test
    @DisplayName("뺄셈 기능 테스트")
    void subtractTest() {
        double result1 = stringCalculator.subtract(4, 5);
        double result2 = stringCalculator.subtract(0, 0);
        double result3 = stringCalculator.subtract(-100, -5);
        double result4 = stringCalculator.subtract(-2, 5);
        double result5 = stringCalculator.subtract(0.5, 0.9);

        assertThat(result1).isEqualTo(-1);
        assertThat(result2).isEqualTo(0);
        assertThat(result3).isEqualTo(-95);
        assertThat(result4).isEqualTo(-7);
        assertThat(result5).isEqualTo(-0.4);
    }

    @Test
    @DisplayName("곱셈 기능 테스트")
    void multipleTest() {
        double result1 = stringCalculator.multiply(4, 5);
        double result2 = stringCalculator.multiply(0, 0);
        double result3 = stringCalculator.multiply(-100, -5);
        double result4 = stringCalculator.multiply(-2, 5);
        double result5 = stringCalculator.multiply(0.5, 0.9);

        assertThat(result1).isEqualTo(20);
        assertThat(result2).isEqualTo(0);
        assertThat(result3).isEqualTo(500);
        assertThat(result4).isEqualTo(-10);
        assertThat(result5).isEqualTo(0.45);
    }

    @Test
    @DisplayName("나눗셈 기능 테스트")
    void divideTest() {
        double result1 = stringCalculator.divide(4, 5);
        double result3 = stringCalculator.divide(-100, -5);
        double result4 = stringCalculator.divide(-2, 5);
        double result5 = stringCalculator.divide(23, 4);

        assertThat(result1).isEqualTo(0.8);
        assertThat(result3).isEqualTo(20);
        assertThat(result4).isEqualTo(-0.4);
        assertThat(result5).isEqualTo(5.75);
    }

    @ParameterizedTest
    @CsvSource(value = {"+, true", "-, true", "*, true", "/, true", "2, false", "0, false"})
    @DisplayName("기호이면 true, 숫자면 false 반환")
    void isSignTest(String input, boolean expected) {
        assertThat(stringCalculator.isSign(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("사칙연산 테스트")
    void fourBasicOperationsTest() {
        assertThat(stringCalculator.start("2 + 3 * 4 / 2")).isEqualTo(10);
        assertThat(stringCalculator.start("1 + 1 + 1 + 1")).isEqualTo(4);
        assertThat(stringCalculator.start("100 / 100 - 5 * 2")).isEqualTo(-8);
        assertThat(stringCalculator.start("-3 - -5")).isEqualTo(2);
        assertThat(stringCalculator.start("1 * 2 * 3")).isEqualTo(6);
        assertThat(stringCalculator.start("99 - 98 * 99 * 0")).isEqualTo(0);
    }
}
