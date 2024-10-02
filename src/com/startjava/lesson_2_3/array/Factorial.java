package com.startjava.lesson_2_3.array;

public class Factorial {
    public static void main(String[] args) {
        int[] num1 = {};
        factorial(num1);
        int[] num2 = null;
        factorial(num2);
        int[] num3 = {0, 8, 0, 9};
        factorial(num3);
        int[] num4 = {-3, 1, 7, 13};
        factorial(num4);
        int[] num5 = {-22, -0};
        factorial(num5);
    }

    public static void factorial(int... args) {
        if (args == null || args.length == 0) {
            System.out.println("Пустой массив или массив со значение null\n");
            return;
        }
        printFactorial(doNewArray(args), args);
    }

    public static long[] doNewArray(int[] array) {
        long[] newArray = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            long factorial = getFactorial(array[i]);
            for (int j = i; j < newArray.length; j++) {
                newArray[j] = factorial;
            }
        }
        return newArray;
    }

    private static long getFactorial(int digit) {
        long result = 1;
        for (int i = 1; i <= digit; i++) {
            result *= i;
        }
        return result;
    }

    private static void printFactorial(long[] array, int[] startArray) {
        for (int i = 0; i < startArray.length; i++) {
            if (startArray[i] == 0 || startArray[i] < 0) {
                System.out.println("Ошибка: факториал " + startArray[i] + "! не определен\n");
                continue;
            }
            System.out.print(startArray[i] + "!");
            if (startArray[i] > 1) {
                System.out.print(" = ");
                for (int j = 1; j <= startArray[i]; j++) {
                    System.out.print(j == 1 ? j : " * " + j);
                }
            }
            System.out.println(" = " + array[i]);
        }
    }
}

