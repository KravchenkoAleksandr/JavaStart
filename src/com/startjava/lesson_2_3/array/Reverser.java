package com.startjava.lesson_2_3.array;

import java.util.Arrays;

public class Reverser {
    public static void main(String[] args) {
        int[] empty = new int[0];
        printReverse("До реверса: ", empty);
        reverseArray(empty);
        printReverse("После реверса: ", empty);
        int[] numbers = {6, 8, 9, 1};
        printReverse("До реверса: ", numbers);
        reverseArray(numbers);
        printReverse("После реверса: ", numbers);
        int[] numbers2 = {13, 8, 5, 3, 2, 1, 1};
        printReverse("До реверса: ", numbers2);
        reverseArray(numbers2);
        printReverse("После реверса: ", numbers2);
        int[] nullable = null;
        printReverse("До реверса: ", nullable);
        reverseArray(nullable);
        printReverse("После реверса: ", nullable);
    }

    public static void printReverse(String s, int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        System.out.printf("%15s", s);
        System.out.println(Arrays.toString(array));
    }

    private static void reverseArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        for (int i = 0; i < len--; i++) {
            int temp = array[i];
            array[i] = array[len];
            array[len] = temp;
        }
    }
}