package game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private static Stream<Arguments> player1WinCases() {
        return Stream.of(
                Arguments.of("paper", "rock"),
                Arguments.of("rock", "scissors"),
                Arguments.of("scissors", "paper")
        );
    }

    private static Stream<Arguments> player1LoseCases() {
        return Stream.of(
                Arguments.of("rock", "paper"),
                Arguments.of("scissors", "rock"),
                Arguments.of("paper", "scissors")
        );
    }

    private static Stream<Arguments> drawCases() {
        return Stream.of(
                Arguments.of("paper", "paper"),
                Arguments.of("rock", "rock"),
                Arguments.of("scissors", "scissors")
        );
    }

    private static Stream<Arguments> invalidChoices() {
        return Stream.of(
                Arguments.of("OWO"),
                Arguments.of("QAQ"),
                Arguments.of(">W<")
        );
    }

    private static Stream<Arguments> validChoices() {
        return Stream.of(
                Arguments.of("paper"),
                Arguments.of("scissors"),
                Arguments.of("rock")
        );
    }

    @Test
    public void whatTest() {
        assertEquals(1, 1);
    }

    @ParameterizedTest
    @MethodSource("player1WinCases")
    void p1WinTest(String A, String B) {
        assertEquals(1, Game.judgeWinner(A, B), "Win cases fail");
    }

    @ParameterizedTest
    @MethodSource("player1LoseCases")
    void p1LostTest(String A, String B) {
        assertEquals(0, Game.judgeWinner(A, B), "Lose cases fail");
    }

    @ParameterizedTest
    @MethodSource("drawCases")
    void bothDrawTest(String A, String B) {
        assertEquals(-1, Game.judgeWinner(A, B), "Draw cases fail");
    }

    @ParameterizedTest
    @MethodSource("invalidChoices")
    void invalidChoiceTest(String in) {
        assertThrows(IllegalArgumentException.class, () -> {
            Game.checkInput(in);
        });
    }

    @ParameterizedTest
    @MethodSource("validChoices")
    void validChoiceTest(String in) {
        assertEquals(true, Game.checkInput(in));
    }
}