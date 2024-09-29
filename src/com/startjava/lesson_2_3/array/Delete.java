package com.startjava.lesson_2_3.array;

import java.util.Random;

public class Delete {

    static double[] arr = new double[15];
    static int counter;
    static int adress;

    public static void main(String[] args) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextDouble(0, 1);
        }
        System.out.println("Исходный массив");
        for (int i = 0; i < arr.length; i++) {
            if (i == 8) {
                System.out.print("\n");
            }
            System.out.printf("%6.3f", arr[i]);
        }
        adress = 0;
        /*
        Для адресов -1 и 15 ошибка ArrayIndexOutOfBoundsException
         */
        changeArray(adress);
        System.out.println("\nИзмененный массив");
        for (int i = 0; i < arr.length; i++) {
            if (i == 8) {
                System.out.print("\n");
            }
            System.out.printf("%6.3f", arr[i]);
        }
        System.out.printf("%n%s%d%n", "Значение из ячейки по переданному адресу ", adress);
        System.out.printf("%s%d%n", "Количество обнуленных ячеек ", counter);

        System.out.println();

        System.out.println("Исходный массив");
        for (int i = 0; i < arr.length; i++) {
            if (i == 8) {
                System.out.print("\n");
            }
            System.out.printf("%6.3f", arr[i]);
        }
        adress = 14;
        changeArray(adress);
        System.out.println("\nИзмененный массив");
        for (int i = 0; i < arr.length; i++) {
            if (i == 8) {
                System.out.print("\n");
            }
            System.out.printf("%6.3f", arr[i]);
        }
        System.out.printf("%n%s%d%n", "Значение из ячейки по переданному адресу ", adress);
        System.out.printf("%s%d%n", "Количество обнуленных ячеек ", counter);
    }

    public static void changeArray(int adress) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[adress]) {
                arr[i] = 0;
                counter++;
            }
        }
    }
}
