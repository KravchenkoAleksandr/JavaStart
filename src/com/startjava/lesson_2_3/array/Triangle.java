package com.startjava.lesson_2_3.array;

public class Triangle {

    static char[] signs;

    public static void main(String[] args) {

        sortSign('0', '9', true);
        System.out.println();
        sortSign('/', '!', false);
        System.out.println();
        sortSign('A', 'J', false);
    }

    public static void sortSign(int start, int end, boolean sort) {
        if (start > end) {
            System.out.println("\nОшибка: левая граница (" + start + ") > правой (" + end + ")");
            return;
        }
        signs = new char[end - start + 1];
        if (sort) {
            for (int i = 0; i < signs.length; i++) {
                signs[i] = (char) start;
                start++;
            }
        } else {
            for (int i = 0; i < signs.length; i++) {
                signs[i] = (char) end;
                end--;
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= signs.length; i++) {
            str.append(" ".repeat(signs.length - i))
                    .append(String.valueOf(signs[i - 1]).repeat(i * 2 - 1))
                    .append("\n");
        }
        System.out.println(str);
    }
}



