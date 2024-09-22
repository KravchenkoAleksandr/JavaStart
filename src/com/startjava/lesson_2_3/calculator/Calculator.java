package com.startjava.lesson_2_3.calculator;

public class Calculator {
    private char sign;
    private int a;
    private int b;

    public Calculator(int a, int b, char sign) {
        this.a = a;
        this.b = b;
        this.sign = sign;
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
                return (double) a / b;
            case '%':
                return a % b;
            case '^':
                return pow();
            default:
                break;
        }
        return 0;
    }

    private double pow() {
        double result = 1;
        for (int i = 1; i <= Math.abs(b); i++) {
            result *= a;
        }
        return b >= 0 ? result : 1 / result;
    }
}