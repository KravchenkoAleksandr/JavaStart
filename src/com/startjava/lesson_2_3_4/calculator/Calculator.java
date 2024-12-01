package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    private static final int MAX_LENGTH_EXPRESSION = 3;

    private Calculator() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static double calculate(String expression) {
        String[] elements = expression.split(" ");
        checkLength(elements);
        int a = checkNumber(elements[0]);
        String sign = elements[1];
        int b = checkNumber(elements[2]);
        return switch (sign) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/", "%" -> {
                checkDivisionByZero(b);
                yield sign.equals("/") ? (double) a / b : Math.floorMod(a, b);
            }
            case "^" -> Math.pow(a, b);
            default -> throw new IllegalArgumentException("Операция " + sign + " не поддерживается");
        };
    }

    private static void checkLength(String[] elements) {
        if (elements.length != MAX_LENGTH_EXPRESSION) {
            throw new LimitExpression("Количество элементов должно равняться " + MAX_LENGTH_EXPRESSION);
        }
    }

    private static int checkNumber(String element) {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ошибка: числа в выражении должно быть целыми!");
        }
    }

    private static void checkDivisionByZero(int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль запрещено!");
        }
    }
}