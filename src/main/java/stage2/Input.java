package stage2;

import java.util.*;
import java.util.regex.Pattern;

public class Input {
    private final Scanner scanner = new Scanner(System.in);

    public Level selectLevel() {
        View.showSelectLevelMessage();
        String level = scanner.nextLine();
        if (isWrongLevel(level)) {
            View.showWrongLevelMessage();
            return selectLevel();
        }
        return convertInputToLevel(level);
    }

    private boolean isWrongLevel(String level) {
        return !Pattern.matches("[123]", level.trim());
    }

    private Level convertInputToLevel(String input) {
        if ("1".equals(input)) {
            return Level.EASY;
        }
        if ("2".equals(input)) {
            return Level.NORMAL;
        }
        if ("3".equals(input)) {
            return Level.HARD;
        }
        return null;
    }

    public List<Integer> getUserNumbers() {
        View.showGetUserNumberMessage();
        String userInput = scanner.nextLine().trim();
        if (isWrongNumbers(userInput)) {
            View.showWrongUserInputNumberMessage();
            return getUserNumbers();
        }
        return convertStringArrayToList(userInput.split(""));
    }

    private boolean isWrongNumbers(String userInput) {
        return !(isRightFormatNumber(userInput) && isNotSameNumber(userInput));
    }

    private boolean isRightFormatNumber(String userInput) {
        return Pattern.matches("^[1-9]{3}$", userInput);
    }

    private boolean isNotSameNumber(String userInput) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            set.add(userInput.charAt(i));
        }
        return set.size() == userInput.length();
    }

    private List<Integer> convertStringArrayToList(String[] userInputs) {
        List<Integer> userNumbers = new ArrayList<>();
        for (String input : userInputs) {
            userNumbers.add(Integer.parseInt(input));
        }
        return userNumbers;
    }

    public boolean askOneMoreGame() {
        View.showRepeatMessage();
        String answer = scanner.nextLine().trim();
        if (isRightContinueResponse(answer)) {
            View.showWrongContinueResponseMessage();
            return askOneMoreGame();
        }
        return convertResponseToBoolean(answer);
    }

    private boolean isRightContinueResponse(String answer) {
        return !Pattern.matches("[12]", answer);
    }

    private boolean convertResponseToBoolean(String answer) {
        return "1".equals(answer);
    }
}