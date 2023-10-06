public class BaseBallGame {

    private static final int RESTART = 1;

    public void play() {
        do {
            startSingleRound();
        } while (isContinueGame());
    }

    private void startSingleRound() {
        Computer computer = new Computer();
        int strikeCount;
        do {
            strikeCount = playSingleGuess(computer);
            ResultView.displayResult(computer.getBalls(), computer.getStrikes());
        } while (strikeCount < 3);
        ResultView.displayGameEndMessage();
    }

    private int playSingleGuess(Computer computer) {
        String userGuess = InputView.getUserGuess();
        return computer.evaluateGuess(userGuess);
    }

    private boolean isContinueGame() {
        return InputView.getUserChoiceForContinue() == RESTART;
    }

    public static void main(String[] args) {
        BaseBallGame game = new BaseBallGame();
        game.play();
    }

}
