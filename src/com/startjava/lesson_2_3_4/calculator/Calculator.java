package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    public double calculates(String expression) {
        String[] elements = expression.split(" ");
        int a = Integer.parseInt(elements[0]);
        char sign = elements[1].charAt(0);
        int b = Integer.parseInt(elements[2]);
        return switch (sign) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/', '%' -> checkZero(a, b, sign);
            case '^' -> Math.pow(a, b);
            default -> {
                System.out.println("Знак " + sign + " не поддерживается");
                yield Double.NaN;
            }
        };
    }

    private static double checkZero(int a, int b, char sign) {
        if (b == 0) {
            System.out.println("Деление на ноль запрещено!");
            return Double.NaN;
        }
        return sign == '/' ? (double) a / b : Math.floorMod(a, b);
    }
}