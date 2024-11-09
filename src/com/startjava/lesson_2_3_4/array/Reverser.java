package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Reverser {
    public static void main(String[] args) {
        int[] empty = new int[0];
        print("До реверса: ", empty);
        reverseArray(empty);
        print("После реверса: ", empty);
        int[] numbers = {6, 8, 9, 1};
        print("До реверса: ", numbers);
        reverseArray(numbers);
        print("После реверса: ", numbers);
        int[] numbers2 = {13, 8, 5, 3, 2, 1, 1};
        print("До реверса: ", numbers2);
        reverseArray(numbers2);
        print("После реверса: ", numbers2);
        int[] nullable = null;
        print("До реверса: ", nullable);
        reverseArray(nullable);
        print("После реверса: ", nullable);
    }

    private static void reverseArray(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Ошибка: пустой массив или массив null");
            return;
        }
        int len = array.length;
        for (int i = 0; i < len--; i++) {
            int temp = array[i];
            array[i] = array[len];
            array[len] = temp;
        }
    }

    private static void print(String msg, int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        System.out.printf("%15s", msg);
        System.out.println(Arrays.toString(array));
    }
}