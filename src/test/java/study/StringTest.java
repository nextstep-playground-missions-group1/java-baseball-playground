package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("1,2을 , 로 split 했을 때 1과 2로 잘 분리하는 테스트")
    void split_1_2() {
        String[] answer = "1,2".split(",");
        assertThat(answer).contains("1", "2");
        assertThat(answer).containsExactly("1", "2");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환하는 테스트")
    void substring_number() {
        String input = "(1,2)";
        String answer = input.substring(input.indexOf('(') + 1, input.lastIndexOf(')'));
        assertThat(answer).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드를 통해 특정 위치의 문자를 가져오는 테스트")
    void get_word_index() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(2)).isEqualTo('c');

        //예외 발생 처리
        assertThatThrownBy(() -> str.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
        assertThrows(StringIndexOutOfBoundsException.class, () -> str.charAt(5));
    }
}
