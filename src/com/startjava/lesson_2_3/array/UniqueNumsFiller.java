package com.startjava.lesson_2_3.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumsFiller {

    static Random rnd = new Random();
    static int[] uniqueNum;

    public static void main(String[] args) {
        fill(-10, 20, 23);
        fill(-30, 10, 10);
        fill(-34, -34, 0);
        fill(-1, 2, -3);
        fill(5, -8, 2);
    }

    public static void fill(int start, int end, int print) {
        double len = (Math.abs(start) + (double) end) * 0.75;
        if (start > end) {
            System.out.println("Ошибка: левая граница (" + end + ") > правой (" + start + ")\n");
            return;
        }
        uniqueNum = new int[(int) Math.ceil(len)];
        if (uniqueNum.length <= 0) {
            System.out.println("Ошибка: длина массива должна быть больше 0 (" + uniqueNum.length + ")\n");
            return;
        }
        for (int i = 0; i < uniqueNum.length;) {
            int unique = rnd.nextInt(start, end + 1);
            boolean isUnique = true;
            for (int j = 0; j <= i; j++) {
                if (unique == uniqueNum[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueNum[i++] = unique;
            }
        }

        Arrays.sort(uniqueNum);
        if (print < 0) {
            System.out.println("Ошибка: количество чисел в строке не может быть меньше 1 (" + print + ")\n");
            return;
        }
        for (int i = 0; i < uniqueNum.length; i++) {
            if (i - print == 0) {
                System.out.println("\n");
                print *= 2;
            }
            System.out.printf("%3d", uniqueNum[i]);
        }
        System.out.println();
        System.out.println();
    }
}
