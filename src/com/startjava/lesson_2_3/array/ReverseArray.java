package com.startjava.lesson_2_3.array;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] numbers = {6, 8, 9, 1};
        System.out.printf("%15s", "До реверса: ");
        printArray(numbers);
        changeArray(numbers);
        System.out.printf("%15s", "После реверса: ");
        printArray(numbers);
    }

    public static void changeArray(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
