package study;
// 요구사항 2
public class StringManipulator {
// 요구사항 2
    public static String removeParentheses(String input) {
        int startIndex = input.indexOf("(");
        int endIndex = input.indexOf(")");

        if (startIndex != -1 && endIndex != -1) {
            String result = input.substring(startIndex + 1, endIndex);
            return result;
        } else {
            return input;
        }
    }

    public static void main(String[] args) {
        String input = "(1,2)";
        String result = removeParentheses(input);
        System.out.println(result);
    }
}
