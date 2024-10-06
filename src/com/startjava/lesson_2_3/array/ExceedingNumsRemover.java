package com.startjava.lesson_2_3.array;

import java.util.Random;

public class ExceedingNumsRemover {
    static int counter;

    public static void main(String[] args) {
        int index = -1;
        float[] randomArrayOne = changeElementsMoreIndex(index);
        print(randomArrayOne,index);
        index = 15;
        float[] randomArrayTwo = changeElementsMoreIndex(index);
        print(randomArrayTwo,index);

        index = 0;
        float[] randomArrayTree = changeElementsMoreIndex(index);
        print(randomArrayTree,index);
        index = 14;
        float[] randomArrayFour = changeElementsMoreIndex(index);
        print(randomArrayFour,index);
    }

    public static float[] changeElementsMoreIndex(int index) {
        float[] randomFloats = new float[15];
        Random rnd = new Random();

        if (index < 0 || index >= randomFloats.length) {
            System.out.println("Индекс должен быть больше нуля и меньше длины массива: " + randomFloats.length + "\n");
            randomFloats = new float[0];
            return randomFloats;
        }
        for (int i = 0; i < randomFloats.length; i++) {
            randomFloats[i] = rnd.nextFloat(0, 1);
        }
        System.out.println("Исходный массив: ");
        for (int i = 0; i < randomFloats.length; i++) {
            if (i == 8) {
                System.out.print("\n");
            }
            System.out.printf("%6.3f", randomFloats[i]);
        }
        for (int i = 0; i < randomFloats.length; i++) {
            if (randomFloats[i] > randomFloats[index]) {
                randomFloats[i] = 0;
                counter++;
            }
        }
        return randomFloats;
    }


    private static void print(float[] array, int index) {
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
        System.out.println("Значение ячейки по переданному адресу: " + array[index]);
        System.out.println("Количество обнуленных ячеек: " + counter + "\n");
    }
}
