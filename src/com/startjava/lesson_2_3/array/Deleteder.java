package com.startjava.lesson_2_3.array;

import java.util.Random;

public class Deleteder {

    public static void main(String[] args) {
        changeArray(-1);
        changeArray(15);
        changeArray(0);
        changeArray(14);
    }

    public static void changeArray(int index) {
        float[] arr = new float[15];
        Random rnd = new Random();

        if (index < 0 || index >= arr.length) {
            System.out.println("Индекс должен быть больше нуля и меньше, либо равен " + arr.length + "\n");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextFloat(0, 1);
        }
        System.out.println("Исходный массив: ");
        print(arr);
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[index]) {
                arr[i] = 0;
                counter++;
            }
        }
        System.out.println("Измененный массив: ");
        print(arr);
        System.out.println("Значение ячейки по переданному адресу: " + index);
        System.out.println("Количество обнуленных ячеек: " + counter + "\n");
    }

    private static void print(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 8) {
                System.out.print("\n");
            }
            System.out.printf("%6.3f", arr[i]);
        }
        System.out.println();
    }
}
