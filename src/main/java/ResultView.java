public class ResultView {
    public static void displayResult(int balls, int strikes) {
        if (balls == 0 && strikes == 0) {
            System.out.println("낫싱");
        } else if (balls > 0 && strikes > 0) {
            System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
        } else if (balls > 0) {
            System.out.printf("%d볼\n", balls);
        } else if (strikes > 0) {
            System.out.printf("%d스트라이크\n", strikes);
        }
    }

    public static void displayGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임을 종료합니다.");
    }

}
