package com.startjava.lesson_2_3.calculator;

import java.util.Scanner;

public class Calculator {

    static Scanner scanner = new Scanner(System.in);
    private char sign;
    private int a;
    private int b;

    public Calculator(int a, int b, char sign) {
        this.a = a;
        this.b = b;
        this.sign = sign;
    }

    public static String[] inputExpression() {
        boolean hasGign = false;
        String[] arrayExpression;
        do {
            String expression = scanner.nextLine();
            String[] signs = {"+", "-", "*", "/", "^", "%"};
            arrayExpression = expression.split(" ");
            for (String s : signs) {
                if (s.equals(arrayExpression[1])) {
                    hasGign = true;
                    break;
                }
            }
            if (!hasGign) {
                System.out.println("Ошибка: операция " + arrayExpression[1] + " не поддерживается");
                System.out.println("Доступны следующие операции: +, -, *, /, ^, %");

            }
        } while (!hasGign);
        return arrayExpression;
    }

    public static Calculator changeText(String[] signs) {
        int x = Integer.parseInt(signs[0]);
        char y = signs[1].charAt(0);
        int z = Integer.parseInt(signs[2]);
        return new Calculator(x, z, y);
    }

    public double calculates() {
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