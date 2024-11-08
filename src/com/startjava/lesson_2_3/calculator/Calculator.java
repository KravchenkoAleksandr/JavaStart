package com.startjava.lesson_2_3.calculator;

public class Calculator {

    public static double calculates(String expression) {
        String[] elements = expression.split(" ");
        int a = Integer.parseInt(elements[0]);
        char sign = elements[1].charAt(0);
        int b = Integer.parseInt(elements[2]);
        return switch (sign) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) {
                    System.out.println("Деление на ноль запрещено!");
                    yield Double.NaN;
                } else {
                    yield (double) a / b;
                }
            }
            case '%' -> {
                if (b == 0) {
                    System.out.println("Деление на ноль запрещено!");
                    yield Double.NaN;
                } else {
                    yield Math.floorMod(a, b);
                }
            }
            case '^' -> Math.pow(a, b);
            default -> {
                System.out.println("Знак " + sign + " не поддерживается");
                yield Double.NaN;
            }
        };
    }
}