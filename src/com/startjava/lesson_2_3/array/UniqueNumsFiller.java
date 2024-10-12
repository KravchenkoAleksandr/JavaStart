package com.startjava.lesson_2_3.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumsFiller {

    static Random rnd = new Random();

    public static void main(String[] args) {
        int[][] numbers = {
                {-10, 20, 23},
                {-30, 10, 10},
                {-34, -34, 0},
                {-1, 2, -3},
                {5, -8, 2}
        };
        for (int[] number : numbers) {
            if (number[0] > number[1]) {
                System.out.println("Ошибка: левая граница (" + number[1] + ") > правой (" + number[0] + ")\n");
                continue;
            }
            if (number[2] <= 0) {
                System.out.println("Ошибка: количество чисел в строке не может быть меньше 1 (" + number[2] + ")\n");
                continue;
            }
            int[] copyArray = fill(number[0], number[1], number[2]);
            printArray(copyArray, number[2]);
        }
    }

    public static int[] fill(int start, int end, int print) {
        if (start > end || print <= 0) {
            return null;
        }
        double len = (Math.abs(start) + end) * 0.75;
        int[] uniqueNums = new int[(int) Math.ceil(len)];
        if (uniqueNums.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < uniqueNums.length; ) {
            int unique = rnd.nextInt(start, end + 1);
            boolean isUnique = true;
            for (int j = 0; j <= i; j++) {
                if (unique == uniqueNums[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueNums[i++] = unique;
            }
        }
        Arrays.sort(uniqueNums);
        return uniqueNums;
    }

    public static void printArray(int[] array, int print) {
        if (array == null) return;
        if (array.length == 0) {
            System.out.println("Ошибка: длина массива должна быть больше 0 (" + array.length + ")\n");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (i - print == 0) {
                System.out.println("\n");
                print *= 2;
            }
            System.out.printf("%3d", array[i]);
        }
        System.out.println();
        System.out.println();
    }
}
