package com.startjava.lesson_2_3.array;

import java.util.Arrays;
import java.util.Random;

public class ArrayUniqueNumbers {

    static Random rnd = new Random();
    static int[] uniqueNum;

    public static void main(String[] args) {
        addNumArray(-10, 20, 23);
        addNumArray(-30, 10, 10);
        addNumArray(-34, -34, 0);
        addNumArray(-1, 2, -3);
        addNumArray(5, -8, 2);
    }

    public static void addNumArray(int start, int end, int print) {
        double len = (Math.abs(start) + (double) end) * 0.75;
        if (start > end) {
            System.out.println("\nОшибка: левая граница (" + end + ") > правой (" + start + ")");
            return;
        }
        uniqueNum = new int[(int) Math.ceil(len)];
        if (uniqueNum.length <= 0) {
            System.out.println("\nОшибка: длина массива должна быть больше 0 (" + uniqueNum.length + ")");
            return;
        }
        for (int i = 0; i < uniqueNum.length; i++) {
            uniqueNum[i] = rnd.nextInt(start, end);
        }
        Arrays.sort(uniqueNum);
        if (print < 0) {
            System.out.println("\nОшибка: количество чисел в строке не может быть меньше 1 (" + print + ")");
            return;
        }
        for (int i = 0; i < uniqueNum.length; i++) {
            if (i - print == 0) {
                System.out.println("\n");
                print *= 2;
            }
            System.out.printf("%3d", uniqueNum[i]);
        }
        System.out.println(" ");
    }
}
