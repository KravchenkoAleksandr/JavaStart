package com.startjava.lesson_2_3.array.hangman;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

    static File file = new File("Words");
    static Random rnd = new Random();
    static Scanner scanner = new Scanner(System.in);
    private final static int ATTEMPS = 6;
    private static int errorCount;
    static boolean hasLetter;
    static String[] gallows = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX"};

    public static void gameplay() throws IOException {
        String[] secretWord = selectSecretWord();
        String[] closeSecretWord = closedSecretWord(secretWord);
        String[] errorLetter = new String[secretWord.length];
        String[] letterInputPlayer = new String[secretWord.length * 2];
        System.out.println("Отгадайте слово из " + secretWord.length + " букв.");
        print(closeSecretWord);
        while (errorCount < ATTEMPS && !isWon(closeSecretWord)) {
            hasLetter = false;
            String letter;
            do {
                System.out.println("Введите букву: ");
                letter = scanner.nextLine().toLowerCase();
                if (isRussian(letter)) {
                    System.out.println("Ошибка: вы ввели букву не из русского алфавита!");
                }
                if (isRepeat(letterInputPlayer, letter)) {
                    System.out.println("Буква введена повторно! Введите другую букву!");
                }
            } while (isRussian(letter) || isRepeat(letterInputPlayer, letter));
            addAllLetter(letter, letterInputPlayer);
            checkInputLetter(letter, secretWord, closeSecretWord);
            counterAttemps(hasLetter);
            System.out.print("Угадываемое слово: ");
            print(closeSecretWord);
            System.out.println(DrawsGallows.valueOf(gallows[errorCount]));
            System.out.println("Количество оставшихся попыток: " + (ATTEMPS - errorCount));
            addErrorLetter(hasLetter, errorLetter, letter);
            System.out.print("Ошибочно введеные букы: ");
            print(errorLetter);

        }
        if (isWon(closeSecretWord)) {
            System.out.println("\nВы выиграли!");
        } else {
            System.out.println("\nВы проиграли!");
        }
        System.out.print("Загаданное слово: ");
        print(secretWord);
    }

    private static String[] selectSecretWord() throws IOException {
        String str = Files.readString(file.toPath());
        String[] words = str.split(",");
        String rndWord = words[rnd.nextInt(words.length)].toLowerCase();
        return rndWord.split("");
    }

    private static String[] closedSecretWord(String[] secretWord) {
        String[] closeSecretWord = new String[secretWord.length];
        Arrays.fill(closeSecretWord, "*");
        return closeSecretWord;
    }

    private static void checkInputLetter(String letter, String[] secretWord, String[] closeSecretWord) {
        for (int i = 0; i < secretWord.length; i++) {
            if (letter.equals(secretWord[i])) {
                closeSecretWord[i] = letter;
                hasLetter = true;
            }
        }
    }

    private static void addErrorLetter(boolean isRight, String[] errorLetter, String letter) {
        if (isRight) return;
        for (int i = 0; i < errorLetter.length; i++) {
            if (errorLetter[i] != null) continue;
            errorLetter[i] = letter.toUpperCase();
            return;

        }
    }

    private static void addAllLetter(String letter, String[] letterInputPlayer) {
        for (int i = 0; i < letterInputPlayer.length; i++) {
            if (letterInputPlayer[i] != null) continue;
            letterInputPlayer[i] = letter;
            return;
        }
    }

    private static boolean isRepeat(String[] letterInputPlayer, String letter) {
        for (String s : letterInputPlayer) {
            if (s == null) continue;
            if (s.equals(letter)) return true;
        }
        return false;
    }

    private static void counterAttemps(boolean hasLetter) {
        if (hasLetter && errorCount != 0) {
            --errorCount;
        } else if (!hasLetter && errorCount < ATTEMPS) {
            ++errorCount;
        }
    }

    private static boolean isRussian(String letter) {
        return letter.matches("[^а-яА-Я]");
    }

    private static void print(String[] array) {
        for (String s : array) {
            if (s != null) {
                System.out.print(s + " ");
            }
        }
        System.out.println();
    }

    private static boolean isWon(String[] closeSecretWord) {
        for (String s : closeSecretWord) {
            if (s.equals("*")) return false;
        }
        return true;
    }
}
