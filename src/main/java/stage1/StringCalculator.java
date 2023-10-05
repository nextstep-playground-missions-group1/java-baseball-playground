package stage1;

import java.util.Scanner;

public class StringCalculator {

    public double add(double result, double newNum) {
        return result + newNum;
    }

    public double subtract(double result, double newNum) {
        return result - newNum;
    }

    public double multiply(double result, double newNum) {
        return result * newNum;
    }

    public double divide(double result, double newNum) {
        return result / newNum;
    }

    public double start(String input) {
        String[] values = input.split(" ");
        return getResult(values);
    }

    private double getResult(String[] values) {
        double result = 0;
        String sign = "";

        for (String value : values) {
            if (isSign(value)) {
                sign = value;
                continue;
            }
            double newNumber = stringToDouble(value);

            if ("+".equals(sign)) {
                result = add(result, newNumber);
                continue;
            }

            if ("-".equals(sign)) {
                result = subtract(result, newNumber);
                continue;
            }

            if ("*".equals(sign)) {
                result = multiply(result, newNumber);
                continue;
            }

            if ("/".equals(sign)) {
                result = divide(result, newNumber);
                continue;
            }

            result = newNumber;
        }
        return result;
    }

    private double stringToDouble(String input) {
        return Double.parseDouble(input);
    }

    public boolean isSign(String value) {
        return "+".equals(value) || "-".equals(value) || "*".equals(value) || "/".equals(value);
    }
}
