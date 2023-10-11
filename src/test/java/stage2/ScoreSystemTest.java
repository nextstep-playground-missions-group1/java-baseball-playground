package stage2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ScoreSystemTest {

    private static ScoreSystem scoreSystem;

    @BeforeAll
    static void scoreSystemInstance() {
        scoreSystem = new ScoreSystem();
    }

    @ParameterizedTest
    @MethodSource("NumbersAndStrikes")
    @DisplayName("컴퓨터 숫자에 맞는 스트라이크 개수")
    void howManyStrikesTest(List<Integer> userNumbers, List<Integer> computerNumbers, int expectedStrikes) {
        Assertions.assertThat(scoreSystem.countStrikes(userNumbers, computerNumbers)).isEqualTo(expectedStrikes);
    }

    static Stream<Arguments> NumbersAndStrikes() {
        return Stream.of(
                Arguments.arguments(new ArrayList<>(List.of(1, 2, 3)), new ArrayList<>(List.of(1, 2, 3)), 3),
                Arguments.arguments(new ArrayList<>(List.of(1, 3, 2)), new ArrayList<>(List.of(1, 2, 3)), 1),
                Arguments.arguments(new ArrayList<>(List.of(1, 2, 4)), new ArrayList<>(List.of(1, 2, 3)), 2),
                Arguments.arguments(new ArrayList<>(List.of(4, 5, 6)), new ArrayList<>(List.of(1, 2, 3)), 0),
                Arguments.arguments(new ArrayList<>(List.of(2, 6, 8)), new ArrayList<>(List.of(4, 6, 8)), 2),
                Arguments.arguments(new ArrayList<>(List.of(3, 7, 2)), new ArrayList<>(List.of(7, 1, 2)), 1),
                Arguments.arguments(new ArrayList<>(List.of(8, 9, 7)), new ArrayList<>(List.of(7, 8, 9)), 0),
                Arguments.arguments(new ArrayList<>(List.of(5, 2, 9)), new ArrayList<>(List.of(5, 2, 9)), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("NumbersAndBalls")
    @DisplayName("컴퓨터 숫자에 맞는 볼 개수")
    void howManyBallsTest(List<Integer> userNumbers, List<Integer> computerNumbers, int strikes, int expectedBalls) {
        Assertions.assertThat(scoreSystem.countBalls(userNumbers, computerNumbers, strikes)).isEqualTo(expectedBalls);
    }

    static Stream<Arguments> NumbersAndBalls() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3), List.of(1, 2, 3), 3, 0),
                Arguments.arguments(List.of(1, 3, 2), List.of(1, 2, 3), 1, 2),
                Arguments.arguments(List.of(1, 2, 4), List.of(1, 2, 3), 2, 0),
                Arguments.arguments(List.of(4, 5, 6), List.of(1, 2, 3), 0, 0),
                Arguments.arguments(List.of(2, 6, 8), List.of(4, 6, 8), 2, 0),
                Arguments.arguments(List.of(3, 7, 2), List.of(7, 1, 2), 1, 1),
                Arguments.arguments(List.of(8, 9, 7), List.of(7, 8, 9), 0, 3),
                Arguments.arguments(List.of(5, 9, 1), List.of(5, 2, 9), 1, 1)
        );
    }
}
