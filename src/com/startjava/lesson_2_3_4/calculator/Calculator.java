package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    private final static int LIMIT = 3;

    public static double calculates(String expression) {
        String[] elements = expression.split(" ");
        checkLength(elements);
        int a = checkNumber(elements[0]);
        String sign = elements[1];
        int b = checkNumber(elements[2]);
        return switch (sign) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/", "%" -> checkZero(a, b, sign);
            case "^" -> Math.pow(a, b);
            default -> throw new IllegalArgumentException("Операция " + sign + " не поддерживается");
        };
    }

    private static void checkLength(String[] elements) throws LimitExpression {
        if (elements.length > LIMIT) {
            throw new LimitExpression("Количество элементов должно равнятся 3");
        }
    }

    private static int checkNumber(String elements) {
        try {
            return Integer.parseInt(elements);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ошибка: числа в выражении должно быть целыми!");
        }
    }

    private static double checkZero(int a, int b, String sign) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль запрещено!");
        }
        return sign.equals("/") ? (double) a / b : Math.floorMod(a, b);
    }
}