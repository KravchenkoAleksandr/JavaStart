package com.startjava.lesson_2_3.array;

public class TypewriterStrings {

    public static void main(String[] args) throws InterruptedException {

        String text = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n- James Gosling\n";
        printText(searchWords(text));
        text = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим, его.\n- Robert Martin\n";
        printText(searchWords(text));
        text = null;
        printText(searchWords(text));
        text = "";
        printText(searchWords(text));
    }

    public static String[] searchWords(String s) {
        if (s == null || s.isBlank()) {
            System.out.print("Строка не может быть пустой или иметь значение null.\n");
            return new String[0];
        }
        String[] words = s.split(" ");
        String longWord = "";
        int indexLongWord = 0;
        String shortWord = s;
        int indexShortWord = 0;

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^а-яА-Яa-zA-Z0-9+]", "");
            if (words[i].length() > longWord.length()) {
                longWord = words[i];
                indexLongWord = i;
            }
            if (words[i].length() < shortWord.length()) {
                if (words[i].isBlank()) continue;
                shortWord = words[i];
                indexShortWord = i;
            }
        }
        int max;
        int min;
        if (indexShortWord > indexLongWord) {
            min = indexLongWord;
            max = indexShortWord;
        } else {
            min = indexShortWord;
            max = indexLongWord;
        }

        String[] finalText = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            while (i >= min && i <= max) {
                finalText[i] = finalText[i].toUpperCase();
                min++;
            }
        }
        return finalText;
    }

    private static void printText(String[] words) throws InterruptedException {
        for (String s : words) {
            for (char sign : s.toCharArray()) {
                System.out.print(sign);
                Thread.sleep(200);
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}
