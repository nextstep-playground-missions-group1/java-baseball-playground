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

/*
궁금한 점!
사용자로부터 입력값을 받아오는 메소드에서 View의 메시지 출력을 넣는게 맞을까?
왜냐하면 어차피 입력값을 받기 전에 안내 메시지가 반드시 등장해야 하기 때문에 포함되는 게 자연스러워 보인다.
하지만 의존관계가 형성되는 게 왠지 찝찝하다.
굳이 Input이 View를 알아야 할까? 그러면서도 또 알면 뭐가 안좋지? 이런 생각이 든다.


Input을 따로 만드는 게 맞을까?
View에서 사용자에게 입력값을 같이 받는 게 맞지 않을까?


View 메소드들을 static으로 했다. 언제 static으로 해야 할지 모르겠다. 일단 View 인스턴스를 여러개 만들지 않을 것이고 해당 메소드만 사용할
의도로 static을 했는데 맞는 기준인지 모르겠다.


재귀함수로 유효성 검사를 하는데, 이것은 단위 테스트가 가능한가? 왜냐하면 예외가 발생하는 것도 아니고
특정 조건에 해당하면 계속 메시지를 호출하는 것이기 때문이다.


멤버 변수로 가지는 게 맞을까? 아니면 메소드의 매개변수로 주고 받는게 나을까? 예를 들어서 사용자 번호나 컴퓨터 번호..
 */