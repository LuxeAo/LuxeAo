package Calc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Введите матемаматический пример в формате:число;операция;число. \n" +
                "Калькулятор работает только с арабскими,либо с римскими числами. \n" +
                "Калькулятор работает только с целыми числами");
        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();
        String output = calc(inputData);
        System.out.println(output);
    }

    public static String calc(String inputData) throws Exception {
        String[] strings = inputData.split(" ");
        int number_1, number_2, resultCalc = 0;
        String operation, Number_1, Number_2, Result = "";
        if (strings.length > 3) {
            throw new Exception("введите пример в формате число;операция;число");
        } else if (strings.length < 3) {
            throw new Exception("строка не является математическим примером");
        }
        operation = strings[1];
        Number_1 = strings[0];
        Number_2 = strings[2];
        try {
            number_1 = Integer.parseInt(Number_1);
            number_2 = Integer.parseInt(Number_2);
            if (number_1 < 1 || number_1 > 10 || number_2 < 1 || number_2 > 10) {
                throw new Exception("Арабские числа не входят в даипозон [1,10]");
            } else {
                switch (operation) {
                    case "+" -> resultCalc = number_1 + number_2;
                    case "-" -> resultCalc = number_1 - number_2;
                    case "*" -> resultCalc = number_1 * number_2;
                    case "/" -> resultCalc = number_1 / number_2;
                    default -> {
                        throw new Exception("арифметический знак не является  +/-/*//");
                    }
                }
            }
            System.out.println(resultCalc);
        } catch (NumberFormatException e) {
            switch (Number_1) {
                case "I" -> number_1 = 1;
                case "II" -> number_1 = 2;
                case "III" -> number_1 = 3;
                case "IV" -> number_1 = 4;
                case "V" -> number_1 = 5;
                case "VI" -> number_1 = 6;
                case "VII" -> number_1 = 7;
                case "VIII" -> number_1 = 8;
                case "IX" -> number_1 = 9;
                case "X" -> number_1 = 10;
                default -> {
                    throw new Exception("смешанные числа");
                }
            }
            switch (Number_2) {
                case "I" -> number_2 = 1;
                case "II" -> number_2 = 2;
                case "III" -> number_2 = 3;
                case "IV" -> number_2 = 4;
                case "V" -> number_2 = 5;
                case "VI" -> number_2 = 6;
                case "VII" -> number_2 = 7;
                case "VIII" -> number_2 = 8;
                case "IX" -> number_2 = 9;
                case "X" -> number_2 = 10;
                default -> {
                    throw new Exception("смешанный числа");
                }
            }
            switch (operation) {
                case "+" -> resultCalc = number_1 + number_2;
                case "-" -> resultCalc = number_1 - number_2;
                case "*" -> resultCalc = number_1 * number_2;
                case "/" -> resultCalc = number_1 / number_2;
                default -> {
                    throw new Exception("арифметический знак не явл. +/-/*//"); 
                }
            }
            if (resultCalc < 1) {
                throw new Exception("римские числа не могут быть < 1");
            }
            int[] num = {100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] figure = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            Result = "";
            for (int i = 0; i < num.length; i++) {
                while (resultCalc >= num[i]) {
                    Result = Result + figure[i];
                    resultCalc = resultCalc - num[i];
                }
            }
        }
        return Result;
    }


}

