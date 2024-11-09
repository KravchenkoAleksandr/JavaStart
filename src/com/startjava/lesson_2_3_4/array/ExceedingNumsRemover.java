package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class ExceedingNumsRemover {

    static int counter;

    public static void main(String[] args) {
        int[] indexes = {-1, 15, 0, 14};
        for (int index : indexes) {
            float[] result = createArray();
            if (index < 0 || index > result.length - 1) {
                System.out.println("Индекс должен быть больше нуля и меньше длины массива: " + (result.length - 1) + "\n");
                continue;
            }
            System.out.println("Исходный массив: ");
            print(index, result);
            result = removeElementsMoreIndex(index, result);
            System.out.println("Измененный массив: ");
            print(index, result);
            printChanges(result, index);
            counter = 0;
        }
    }

    private static float[] createArray() {
        Random rnd = new Random();
        float[] newArray = new float[15];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = rnd.nextFloat(0, 1);
        }
        return newArray;
    }

    private static float[] removeElementsMoreIndex(int index, float[] randomFloats) {
        if (index < 0 || index > randomFloats.length) {
            return new float[0];
        }
        for (int i = 0; i < randomFloats.length; i++) {
            if (randomFloats[i] > randomFloats[index]) {
                randomFloats[i] = 0;
                counter++;
            }
        }
        return randomFloats;
    }

    private static void print(int index, float[] array) {
        if (index < 0 || index >= array.length) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (i == 8) {
                System.out.print("\n");
            }
            System.out.printf("%6.3f", array[i]);
        }
        System.out.println();
    }

    private static void printChanges(float[] array, int index) {
        if (index < 0 || index > array.length - 1) return;
        System.out.printf("%s%.3f%n", "Значение из ячейки по переданному индексу: ", array[index]);
        System.out.println("Количество обнуленных ячеек: " + counter + "\n");
    }
}
