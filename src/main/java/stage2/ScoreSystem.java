package stage2;

import java.util.List;

public class ScoreSystem {
    private int strikes;

    public int countStrikes(List<Integer> userNumbers, List<Integer> computerNumbers) {
        strikes = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            boolean isStrike = isStrike(userNumbers.get(i), computerNumbers.get(i));
            strikes += convertBooleanToInt(isStrike);
        }
        return strikes;
    }

    private boolean isStrike(int userNumber, int computerNumber) {
        return userNumber == computerNumber;
    }

    public int countBalls(List<Integer> userNumbers, List<Integer> computerNumbers) {
        return countHowManyNumbersMatch(userNumbers, computerNumbers) - strikes;
    }

    /*
    포함되어 있느냐?란 질문에 is... 가 맞을까?
     */
    private int countHowManyNumbersMatch(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int totalMatches = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            boolean isContain = isUserNumberInComputerNumbers(userNumbers.get(i), computerNumbers);
            totalMatches += convertBooleanToInt(isContain);
        }
        return totalMatches;
    }

    /*
    이게 고민되는 부분. 숫자 하나가 리스트에 포함되어 있는지 확인하는 메소드인데, isCount라는 느낌이라 반환값이 boolean이 되어야 할 것 같지만
    실제로 포함되면 +1을 해야 한다. 반환값이랑 매칭이 안되는 느낌이다.
     */
    private boolean isUserNumberInComputerNumbers(int userNumber, List<Integer> computerNumbers) {
        return computerNumbers.contains(userNumber);
    }

    private int convertBooleanToInt(boolean value) {
        return -("false".indexOf("" + value));
    }
}
