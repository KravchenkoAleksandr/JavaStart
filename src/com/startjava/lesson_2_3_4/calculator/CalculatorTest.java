package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuation = "yes";
        while (!continuation.equals("no")) {
            if (continuation.equals("yes")) {
                System.out.println("Введите математическое выражение:");
                String expression = inputExpression(scanner);
                try {
                    double result = Calculator.calculates(expression);
                    print(result);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Хотите продолжить вычисления? [yes / no]:");
            } else {
                System.out.println("Введите корректный ответ [yes / no]:");
            }
            continuation = scanner.nextLine().toLowerCase();
        }
    }

    private static String inputExpression(Scanner console) {
        return console.nextLine()
                .trim()
                .replaceAll("\\s+", " ");
    }

    private static void print(double result) {
        System.out.println(new DecimalFormat("#.###").format(result));
    }
}

