package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    public static double calculates(String expression) {
        String[] elements = expression.split(" ");
        int a = Integer.parseInt(elements[0]);
        char sign = elements[1].charAt(0);
        int b = Integer.parseInt(elements[2]);
        switch (sign) {
            case '+' -> {
                return a + b;
            }
            case '-' -> {
                return a - b;
            }
            case '*' -> {
                return a * b;
            }
            case '/', '%' -> {
                if (b == 0) {
                    System.out.println("Деление на ноль запрещено!");
                    return Double.NaN;
                }
                return sign == '/' ? (double) a / b : Math.floorMod(a, b);
            }
            case '^' -> {
                return Math.pow(a, b);
            }
            default -> {
                System.out.println("Знак " + sign + " не поддерживается");
                return Double.NaN;
            }
        }
    }
}