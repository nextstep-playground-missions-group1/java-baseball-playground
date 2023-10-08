package stage2;

import java.util.*;

public class NumberBaseballGame {

    private final Input input = new Input();
    private final Random random = new Random();
    private final ScoreSystem scoreSystem = new ScoreSystem();
    private List<Integer> computerNumbers;
    private final int strikeout = 3;
    private int chances;

    public void gameStart() {
        View.showGameIntro();
        playGame();
    }

    private void playGame() {
        setChances(input.selectLevel());
        computerNumbers = setComputerNumbers(new HashSet<>());
        usesOneChance();
        View.showRightAnswer(computerNumbers);
        if (input.askOneMoreGame()) {
            playGame();
        }
        endGame();
    }

    private void setChances(Level level) {
        View.showChosenChanceMessage(level);
        chances = level.getChances();
    }

    private List<Integer> setComputerNumbers(Set<Integer> tempNumberSet) {
        tempNumberSet.add(random.nextInt(9) + 1);
        if (tempNumberSet.size() < 3) {
            setComputerNumbers(tempNumberSet);
        }
        return new ArrayList<>(tempNumberSet);
    }

    private void usesOneChance() {
        if (isZeroChance()) {
            View.showFailMessage();
            return;
        }
        View.showLeftChances(chances--);
        List<Integer> userNumbers = input.getUserNumbers();

        int strikes = scoreSystem.countStrikes(userNumbers, computerNumbers);
        int balls = scoreSystem.countBalls(userNumbers, computerNumbers);
        View.showScores(strikes, balls);

        if (isThreeStrikes(strikes)) {
            View.showCompleteMessage();
            return;
        }
        usesOneChance();
    }

    private boolean isZeroChance() {
        return chances == 0;
    }

    private boolean isThreeStrikes(int strikes) {
        return strikes == strikeout;
    }

    private void endGame() {
        View.showEndMessage();
    }
}
