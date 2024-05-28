import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split("\\s+");
        if (split.length > 3) {
            throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (split.length < 3) {
            throw new IllegalArgumentException("строка не является математической операцией");
        }
        String operand1 = split[0];
        String operator = split[1];
        String operand2 = split[2];


        if (isNumber(operand1) && isNumber(operand2)) {
            int digit1 = Integer.parseInt(operand1);
            int digit2 = Integer.parseInt(operand2);
            if (digit1 < 1 || digit1 > 10 || digit2 < 1 || digit2 > 10) {
                throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10.");
            }
            System.out.println(Calculated.Calc(digit1, operator, digit2));
        } else if (isRoman(operand1) && isRoman(operand2)) {
            int number1 = Converter.romanToArabic(operand1);
            int number2 = Converter.romanToArabic(operand2);
            int result = Calculated.Calc(number1, operator, number2);
            String romanResult = Converter.arabicToRoman(result);
            if (result < 1) {
                throw new IllegalArgumentException("В римской системе нет отрицательных чисел");
            }
            System.out.println(romanResult);
        } else {
            throw new IllegalArgumentException("Используются одновременно разные системы счисления");
        }

    }

    private static boolean isNumber(String str) {
        return str.matches("[0-9]+");
    }

    private static boolean isRoman(String str) {
        return str.matches("[IVX]+");
    }

}
