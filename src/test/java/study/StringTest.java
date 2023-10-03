package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test   // 요구사항 1
    void splitComma() {
        String input1 = "1,2";
        String[] result1 = input1.split(",");
        assertThat(result1).contains("1", "2");

        String input2 = "1";
        String[] result2 = input2.split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test   // 요구사항 3
    @DisplayName("charAt 메소드로 특정 위치의 문자 가져오기")
    void testCharAt() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 메소드 사용할 때 위치 값이 벗어나면 StringIndexOutOfBoundException 예외 발생")
    void testCharAtException() {
        String str = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> str.charAt(3))
            .withMessageMatching("String index out of range: 3");
    }
}

