package stage1;

import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);

        double answer = stringCalculator.start(scanner.nextLine());
        System.out.println(answer);
    }
}
