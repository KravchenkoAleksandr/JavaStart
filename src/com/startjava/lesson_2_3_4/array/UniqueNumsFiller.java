package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumsFiller {

    static Random rnd = new Random();

    public static void main(String[] args) {
        int[][] matrix = {
                {-10, 20, 23},
                {-30, 10, 10},
                {-34, -34, 0},
                {-1, 2, -3},
                {5, -8, 2}
        };
        for (int[] numbers : matrix) {
            if (numbers[0] > numbers[1]) {
                System.out.println("Ошибка: левая граница (" + numbers[1] + ") > правой (" + numbers[0] + ")\n");
                continue;
            }
            if (numbers[2] <= 0) {
                System.out.println("Ошибка: количество чисел в строке не может быть меньше 1 (" + numbers[2] + ")\n");
                continue;
            }
            int[] copyArray = fill(numbers[0], numbers[1], numbers[2]);
            printArray(copyArray, numbers[2]);
        }
    }

    public static int[] fill(int start, int end, int quantity) {
        if (start > end || quantity <= 0) {
            return new int[0];
        }
        double len = (Math.abs(start) + end) * 0.75;
        int[] uniqueNums = new int[(int) Math.ceil(len)];
        if (uniqueNums.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < uniqueNums.length; ) {
            int num = rnd.nextInt(start, end + 1);
            boolean isUnique = true;
            for (int j = 0; j <= i; j++) {
                if (num == uniqueNums[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueNums[i++] = num;
            }
        }
        Arrays.sort(uniqueNums);
        return uniqueNums;
    }

    public static void printArray(int[] array, int quantity) {
        int len = array.length;
        if (len == 0) {
            System.out.println("Ошибка: длина массива должна быть больше 0 (" + array.length + ")\n");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (i - quantity == 0) {
                System.out.println("\n");
                quantity *= 2;
            }
            System.out.printf("%3d ", array[i]);
        }
        System.out.println("\n");
    }
}
