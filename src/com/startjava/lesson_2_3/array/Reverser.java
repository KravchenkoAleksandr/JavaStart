package com.startjava.lesson_2_3.array;

import java.util.Arrays;

public class Reverser{
    public static void main(String[] args) {
        int[] zero = new int[0];
        printReverse(zero);
        int[] numbers = {6, 8, 9, 1};
        printReverse(numbers);
        int[] numbers2 = {13, 8, 5, 3, 2, 1, 1};
        printReverse(numbers2);
        int[] text = null;
        printReverse(text);
    }

    public static void printReverse(int[] array) {
        System.out.printf("%15s", "До реверса: ");
        System.out.println(Arrays.toString(array));
        reverseArray(array);
        System.out.printf("%15s", "После реверса: ");
        System.out.println(Arrays.toString(array));
    }

    private static void reverseArray(int[] array) {
        int len = array.length;
        for (int i = 0; i < len--; i++) {
            int temp = array[i];
            array[i] = array[len];
            array[len] = temp;
        }
    }

}
