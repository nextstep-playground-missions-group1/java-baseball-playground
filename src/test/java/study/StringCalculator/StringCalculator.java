package study.StringCalculator;

public class StringCalculator {
    public static int calculate(String input) {
        String[] tokens = input.split(" ");

        if (tokens.length < 3 || tokens.length % 2 == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int result = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int operand = Integer.parseInt(tokens[i + 1]);

            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                case "/":
                    if (operand == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result /= operand;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator");
            }
        }
        return result;
    }
}
