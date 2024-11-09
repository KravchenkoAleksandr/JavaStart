package com.startjava.lesson_2_3_4.array;

public class TypewriterEffect {

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

    private static String[] searchWords(String inputText) {
        if (inputText == null || inputText.isBlank()) {
            System.out.print("Строка не может быть пустой или иметь значение null.\n");
            return new String[0];
        }
        String[] words = inputText.split(" ");
        String longWord = "";
        int indexStart = 0;
        String shortWord = inputText;
        int indexFinish = 0;

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^а-яА-Яa-zA-Z0-9+]", "");
            if (words[i].length() > longWord.length()) {
                longWord = words[i];
                indexStart = i;
            }
            if (words[i].length() < shortWord.length()) {
                if (words[i].isBlank()) continue;
                shortWord = words[i];
                indexFinish = i;
            }
        }
        if (indexStart > indexFinish) {
            int tmp = indexStart;
            indexStart = indexFinish;
            indexFinish = tmp;
        }
        String[] finalText = inputText.split(" ");
        for (int i = indexStart; i <= indexFinish; i++) {
            finalText[i] = finalText[i].toUpperCase();
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
