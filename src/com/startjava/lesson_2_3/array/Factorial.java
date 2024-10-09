package com.startjava.lesson_2_3.array;

public class Factorial {
    public static void main(String[] args) {
        int[] empty = {};
        long[] result = calcFactorial(empty);
        printResults(result, empty);
        int[] nulable = null;
        result = calcFactorial(nulable);
        printResults(result, nulable);
        int[] fourNums = {0, 8, 0, 9};
        result = calcFactorial(fourNums);
        printResults(result, fourNums);
        int[] secondFourNum = {-3, 1, 7, 13};
        result = calcFactorial(secondFourNum);
        printResults(result, secondFourNum);
        int[] negativeNums = {-22, -0};
        result = calcFactorial(negativeNums);
        printResults(result, negativeNums);
    }

    private static long[] calcFactorial(int... array) {
        if (array == null || array.length == 0) {
            return new long[0];
        }
        long[] factorialResults = new long[array.length];
        for (int i = 0; i < factorialResults.length; i++) {
            long result = 1;
            for (int j = 1; j <= array[i]; j++) {
                result *= j;
            }
            factorialResults[i] = result;
        }
        return factorialResults;
    }

    private static void printResults(long[] factorials, int[] startArray) {
        if (startArray == null || startArray.length == 0) {
            System.out.println("Пустой массив или массив со значение null\n");
            return;
        }
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

