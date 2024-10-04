package com.startjava.lesson_2_3.array;

public class Factorial {
    public static void main(String[] args) {
        factorial();
        factorial(null);
        factorial(0, 8, 0, 9);
        factorial(-3, 1, 7, 13);
        factorial(-22, -0);
    }

    public static void factorial(int... args) {
        if (args == null || args.length == 0) {
            System.out.println("Пустой массив или массив со значение null\n");
            return;
        }
        printFactorial(doArrayFactorial(args), args);
    }

    public static long[] doArrayFactorial(int[] array) {
        long[] factorialsArray = new long[array.length];
        for (int i = 0; i < factorialsArray.length; i++) {
             factorialsArray[i] = calcFactorial(array[i]);

        }
        return factorialsArray;
    }

    private static long calcFactorial(int digit) {
        long result = 1;
        for (int i = 1; i <= digit; i++) {
            result *= i;
        }
        return result;
    }

    private static void printFactorial(long[] factorials, int[] startArray) {
        for (int i = 0; i < startArray.length; i++) {
            if (startArray[i] < 0) {
                System.out.println("Ошибка: факториал " + startArray[i] + "! не определен");
                continue;
            }
            System.out.print(startArray[i] + "!");
            if (startArray[i] > 1) {
                System.out.print(" = ");
                for (int j = 1; j <= startArray[i]; j++) {
                    System.out.print(j == 1 ? j : " * " + j);
                }
            }
            System.out.println(" = " + factorials[i]);
        }
        System.out.println();
    }
}

