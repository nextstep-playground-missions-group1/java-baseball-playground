package stage2;

import java.util.List;

public class View {
    private static final String LINE = "=========";

    public static void showGameIntro() {
        System.out.print(LINE);
        System.out.print(" 숫자 야구 게임 ");
        System.out.println(LINE);
    }

    public static void showSelectLevelMessage() {
        System.out.println("난이도를 선택하세요.");
        System.out.println("* EASY  →  7번 기회");
        System.out.println("* NORMAL  →  6번 기회");
        System.out.println("* HARD  →  5번 기회");
        System.out.println("(1) EASY, (2) NORMAL, (3) HARD");
        System.out.print("> ");
    }

    public static void showWrongLevelMessage() {
        System.out.println("\n잘못된 레벨 선택을 하셨습니다. 1~3 중 선택 하세요.");
    }

    public static void showChosenChanceMessage(Level level) {
        System.out.printf("[%s]를 선택하셨습니다.\n", level.getLevel());
        System.out.printf("기회는 총 [%d]번 입니다.\n\n", level.getChances());
    }

    public static void showGetUserNumberMessage() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void showScores(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱\n");
            return;
        }
        if (ball != 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }
        System.out.println(sb.append("\n"));
    }

    public static void showCompleteMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다!");
        System.out.println("게임을 종료합니다.");
    }

    public static void showFailMessage() {
        System.out.println("아쉽습니다. 다시 도전하시겠습니까?");
    }

    public static void showLeftChances(int leftChances) {
        if (leftChances == 1) {
            System.out.println("마지막 기회입니다! 신중히 선택하세요.");
        }
        System.out.printf("[%d]번의 기회가 남아 있습니다.\n", leftChances);
    }

    public static void showRepeatMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2 를 입력하세요.");
        System.out.print("> ");
    }

    public static void showRightAnswer(List<Integer> computerNumbers) {
        StringBuilder computerNumber = new StringBuilder();
        for (Integer number : computerNumbers) {
            computerNumber.append(number);
        }
        System.out.printf("정답은 '%s' 입니다!\n", computerNumber);
    }

    public static void showEndMessage() {
        System.out.println("\n숫자 야구 게임 프로그램을 종료합니다.");
        System.out.println("감사합니다.");
    }

    public static void showWrongContinueResponseMessage() {
        System.out.println("잘못된 입력 값 입니다.\n");
    }

    public static void showWrongUserInputNumberMessage() {
        System.out.println("\n1~9로 이루어진 서로 다른 숫자 3개를 입력하세요.");
    }
}
