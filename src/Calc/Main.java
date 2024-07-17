package Calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<String, Integer> romanToArabic = new HashMap<>();
    private static final Map<Integer, String> arabicToRoman = new HashMap<>();

    static {
        romanToArabic.put("I", 1);
        romanToArabic.put("II", 2);
        romanToArabic.put("III", 3);
        romanToArabic.put("IV", 4);
        romanToArabic.put("V", 5);
        romanToArabic.put("VI", 6);
        romanToArabic.put("VII", 7);
        romanToArabic.put("VIII", 8);
        romanToArabic.put("IX", 9);
        romanToArabic.put("X", 10);

        arabicToRoman.put(100, "C");
        arabicToRoman.put(90, "XC");
        arabicToRoman.put(50, "L");
        arabicToRoman.put(40, "XL");
        arabicToRoman.put(10, "X");
        arabicToRoman.put(9, "IX");
        arabicToRoman.put(5, "V");
        arabicToRoman.put(4, "IV");
        arabicToRoman.put(1, "I");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Введите матемаматический пример в формате: число операция число. \n" +
                "Калькулятор работает только с арабскими, либо с римскими числами. \n" +
                "Калькулятор работает только с целыми числами");
        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine(); // Считывание примера с консоли
        scanner.close();
        String output = calc(inputData);
        System.out.println(output);
    }

    public static String calc(String inputData) throws Exception {
        String[] strings = inputData.split(" "); // Разбиение массива с пробелами
        if (strings.length != 3) {
            throw new Exception("Введите пример в формате число операция число");
        }

        String operation = strings[1];
        String number1Str = strings[0];
        String number2Str = strings[2];

        int number1 = parseNumber(number1Str);
        int number2 = parseNumber(number2Str);

        if (number1 < 1 || number1 > 10 || number2 < 1 || number2 > 10) {
            throw new Exception("Числа должны быть в диапазоне от 1 до 10");
        }

        int result = performOperation(number1, number2, operation);

        if (isRoman(number1Str) && isRoman(number2Str)) {
            if (result < 1) {
                throw new Exception("Римские числа не могут быть меньше 1");
            }
            return convertToRoman(result);
        } else {
            return String.valueOf(result);
        }
    }

    private static int parseNumber(String numberStr) throws Exception {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            Integer value = romanToArabic.get(numberStr);
            if (value == null) {
                throw new Exception("Некорректное число: " + numberStr);
            }
            return value;
        }
    }

    private static int performOperation(int number1, int number2, String operation) throws Exception {
        return switch (operation) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "*" -> number1 * number2;
            case "/" -> number1 / number2;
            default -> throw new Exception("Некорректная операция: " + operation);
        };
    }

    private static boolean isRoman(String numberStr) {
        return romanToArabic.containsKey(numberStr);
    }

    private static String convertToRoman(int number) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : arabicToRoman.entrySet()) {
            while (number >= entry.getKey()) {
                result.append(entry.getValue());
                number -= entry.getKey();
            }
        }
        return result.toString();
    }
}

