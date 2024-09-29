package com.startjava.lesson_2_3.array;

import java.util.Arrays;

public class Converter{
    public static void main(String[] args) {
        int[] zero = new int[0];
        //String[] text = new String[]; в массиве int не может храниться значение null
        int[] numbers = {6, 8, 9, 1};
        int[] numbers2 = {13, 8, 5, 3, 2, 1, 1};
        printBeforeReverse(zero);
        reverseArray(zero);
        printAfterReverse(zero);
        //changeArray(text); в массиве int не может храниться значение null
        printBeforeReverse(numbers);
        reverseArray(numbers);
        printAfterReverse(numbers);
        printBeforeReverse(numbers2);
        reverseArray(numbers2);
        printAfterReverse(numbers2);
    }

    public static void reverseArray(int[] array) {
        int len = array.length;
        for (int i = 0; i < len / 2; i++) {
            int temp = array[i];
            array[i] = array[len - 1 - i];
            array[len - 1 - i] = temp;
        }
    }

    private static void printBeforeReverse(int[] array) {
        System.out.printf("%15s", "До реверса: ");
        System.out.println(Arrays.toString(array));
    }

    private static void printAfterReverse(int[] array) {
        System.out.printf("%15s", "После реверса: ");
        System.out.println(Arrays.toString(array));
    }
}
