package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String continuation = "yes";
        while (!continuation.equals("no")) {
            if (continuation.equals("yes")) {
                System.out.println("Введите математическое выражение:");
                String expression = scanner.nextLine();
                double result = calculator.calculates(expression);
                print(result);
                System.out.println("Хотите продолжить вычисления? [yes / no]:");
            } else {
                System.out.println("Введите корректный ответ [yes / no]:");
            }
            continuation = scanner.nextLine().toLowerCase();
        }
    }

    private static void print(double result) {
        if (!Double.isNaN(result)) {
            DecimalFormat decimalFormat = new DecimalFormat("#.###");
            System.out.println(decimalFormat.format(result));
        }
    }
}
