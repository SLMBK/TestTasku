public class Calculated {
    int number1;
    String operand;
    int number2;

    public static int Calc(int number1, String operand, int number2) {
        switch (operand) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
        }
        return 0;
    }
}
