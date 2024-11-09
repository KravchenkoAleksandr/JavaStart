package com.startjava.lesson_2_3_4.array;

public class AsciiTrianglePrinter {

    public static void main(String[] args) {
        printTriangle('0', '9', true);
        System.out.println();
        printTriangle('/', '!', false);
        System.out.println();
        printTriangle('A', 'J', false);
    }

    public static void printTriangle(int start, int end, boolean isAscending) {
        if (start > end) {
            System.out.println("Ошибка: левая граница (" + start + ") > правой (" + end + ")");
            return;
        }
        char[] signs = new char[end - start + 1];
        for (int i = 0; i < signs.length; i++) {
            signs[i] = isAscending ? (char) start++ : (char) end--;
        }
        StringBuilder triangle = new StringBuilder();
        for (int i = 1; i <= signs.length; i++) {
            triangle.append(" ".repeat(signs.length - i))
                    .append(String.valueOf(signs[i - 1]).repeat(i * 2 - 1))
                    .append("\n");
        }
        System.out.print(triangle);
    }
}



