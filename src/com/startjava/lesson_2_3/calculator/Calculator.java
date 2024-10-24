package com.startjava.lesson_2_3.calculator;

public class Calculator {

    public static double calculates(String expression) {
        String[] example = expression.split(" ");
        int a = Integer.parseInt(example[0]);
        char sign = example[1].charAt(0);
        int b = Integer.parseInt(example[2]);
        switch (sign) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    System.out.println("Деление на ноль запрещено!");
                    return Double.NaN;
                } else {
                    return (double) a / b;
                }
            case '%':
                if (b == 0) {
                    System.out.println("Деление на ноль запрещено!");
                    return Double.NaN;
                } else {
                    return Math.floorMod(a, b);
                }
            case '^':
                return Math.pow(a, b);
            default:
                break;
        }
        return 0;
    }

}