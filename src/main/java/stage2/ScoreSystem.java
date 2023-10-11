package stage2;

import java.util.List;

public class ScoreSystem {

    public int countStrikes(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int strikes = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            boolean isStrike = isStrike(userNumbers.get(i), computerNumbers.get(i));
            strikes += convertBooleanToInt(isStrike);
        }
        return strikes;
    }

    private boolean isStrike(int userNumber, int computerNumber) {
        return userNumber == computerNumber;
    }

    private int convertBooleanToInt(boolean value) {
        return -("false".indexOf("" + value));
    }

    public int countBalls(List<Integer> userNumbers, List<Integer> computerNumbers, int strikes) {
        return countHowManyNumbersMatch(userNumbers, computerNumbers) - strikes;
    }

    private int countHowManyNumbersMatch(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int totalMatches = 0;
        for (Integer userNumber : userNumbers) {
            boolean isContain = isUserNumberInComputerNumbers(userNumber, computerNumbers);
            totalMatches += convertBooleanToInt(isContain);
        }
        return totalMatches;
    }

    private boolean isUserNumberInComputerNumbers(int userNumber, List<Integer> computerNumbers) {
        return computerNumbers.contains(userNumber);
    }
}
