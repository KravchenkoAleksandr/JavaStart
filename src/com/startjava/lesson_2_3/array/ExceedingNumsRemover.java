package com.startjava.lesson_2_3.array;

import java.util.Random;

public class ExceedingNumsRemover {

    static int counter;

    public static void main(String[] args) {
        int index = -1;
        float[] result = createArray(index);
        print(index, result);
        result = removeElementsMoreIndex(index, result);
        print(index, result);
        printChanges(result, index);

        index = 15;
        result = createArray(index);
        print(index, result);
        result = removeElementsMoreIndex(index, result);
        print(index, result);
        printChanges(result, index);

        index = 0;
        result = createArray(index);
        print(index, result);
        result = removeElementsMoreIndex(index, result);
        print(index, result);
        printChanges(result, index);

        index = 14;
        result = createArray(index);
        print(index, result);
        result = removeElementsMoreIndex(index, result);
        print(index, result);
        printChanges(result, index);
    }

    private static float[] createArray(int index) {
        Random rnd = new Random();
        float[] newArray = new float[15];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = rnd.nextFloat(0, 1);
        }
        if (index >= 0 && index <= newArray.length - 1) System.out.println("Исходный массив: ");
        return newArray;
    }

    private static float[] removeElementsMoreIndex(int index, float[] randomFloats) {
        if (index < 0 || index >= randomFloats.length) {
            System.out.println("Индекс должен быть больше нуля и меньше длины массива: " + randomFloats.length + "\n");
            return new float[0];
        }
        if (index > 0 || index < randomFloats.length - 1) {
            System.out.println("Измененный массив: ");
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
