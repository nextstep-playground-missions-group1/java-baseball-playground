package stage1;

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
            result = calculate(sign, result, stringToDouble(value));
        }

        return result;
    }

    private double calculate(String sign, double result, double newNumber) {
        if ("+".equals(sign)) {
            return add(result, newNumber);
        }
        if ("-".equals(sign)) {
            return subtract(result, newNumber);
        }
        if ("*".equals(sign)) {
            return multiply(result, newNumber);
        }
        if ("/".equals(sign)) {
            return divide(result, newNumber);
        }
        return newNumber;
    }

    private double stringToDouble(String input) {
        return Double.parseDouble(input);
    }

    public boolean isSign(String value) {
        return "+".equals(value) || "-".equals(value) || "*".equals(value) || "/".equals(value);
    }
}
