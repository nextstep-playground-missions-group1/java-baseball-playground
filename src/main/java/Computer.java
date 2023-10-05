import java.util.ArrayList;
import java.util.Random;
public class Computer {

    private final ArrayList<Integer> numbers;
    private int balls;
    private int strikes;

    public Computer() {
        numbers = generateNumbers();
        balls = 0;
        strikes = 0;
    }

    public ArrayList<Integer> generateNumbers() {
        ArrayList<Integer> nums = new ArrayList<>();
        Random rand = new Random();
        while (nums.size() < 3) {
            int randomNum = rand.nextInt(9) + 1;
            if (!nums.contains(randomNum)) {
                nums.add(randomNum);
            }
        }
        return nums;
    }

    public int evaluateGuess(String guess) {
        resetCounts();
        for (int i = 0; i < 3; i++) {
            int guessedNum = Character.getNumericValue(guess.charAt(i));
            evaluateNumber(guessedNum, i);
        }
        return strikes;
    }

    private void resetCounts() {
        balls = 0;
        strikes = 0;
    }

    private void evaluateNumber(int guessedNum, int position) {
        if (numbers.get(position) == guessedNum) {
            strikes++;
        } else if (numbers.contains(guessedNum)) {
            balls++;
        }
    }

    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }
}
