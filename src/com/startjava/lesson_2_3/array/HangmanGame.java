package com.startjava.lesson_2_3.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

    private static final String[] gallows = {
            "________",
            "|      |",
            "|      @",
            "|     /|\\",
            "|     / \\",
            "| GAME OVER!"
    };
    private static final int ATTEMPS = gallows.length;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String[] secretWord = selectSecretWord();
        String[] closeSecretWord = maskSecretWord(secretWord);
        String[] wrongLetters = new String[secretWord.length];
        String[] enteredLetters = new String[secretWord.length * 2];
        System.out.println("Отгадайте слово из " + secretWord.length + " букв.");
        print(closeSecretWord);
        int errorCount = 0;
        while (errorCount < ATTEMPS && !isWon(closeSecretWord, secretWord)) {
            String letter;
            boolean isCyrillicLetter;
            boolean isRepeated;
            do {
                System.out.println("Введите букву: ");
                letter = inputLetter(scanner);
                isCyrillicLetter = isCyrillic(letter);
                isRepeated = isRepeat(enteredLetters, letter);
                if (isCyrillicLetter) {
                    System.out.println("Ошибка: вы ввели букву не из русского алфавита!");
                }
                if (isRepeated) {
                    System.out.println("Буква введена повторно! Введите другую букву!");
                }
            } while (isCyrillicLetter || isRepeated);
            addAllLetter(letter, enteredLetters);
            boolean hasLetter;
            hasLetter = checkInputLetter(letter, secretWord, closeSecretWord);
            errorCount = calcAttemps(hasLetter, errorCount);
            System.out.println("________________________________________________________");
            System.out.print("Угадываемое слово: ");
            print(closeSecretWord);
            printGallows(errorCount, gallows);
            System.out.println("Количество оставшихся попыток: " + (ATTEMPS - errorCount));
            addErrorLetter(hasLetter, wrongLetters, letter);
            System.out.print("Ошибочно введенные букы: ");
            print(wrongLetters);
            System.out.println("________________________________________________________");


        }
        if (isWon(closeSecretWord, secretWord)) {
            System.out.println("Вы выиграли!");
        } else {
            System.out.println("Вы проиграли!");
        }
        System.out.print("Загаданное слово: ");
        print(secretWord);
    }

    private static String[] selectSecretWord() {
        Random rnd = new Random();
        String[] words = {"Ученый", "Восстановление", "Телеграф", "Профиль", "Синтаксис", "Спортсмен", "Керамика"};
        String secretWord = words[rnd.nextInt(words.length)].toLowerCase();
        return secretWord.split("");
    }

    private static String[] maskSecretWord(String[] secretWord) {
        String[] closeSecretWord = new String[secretWord.length];
        Arrays.fill(closeSecretWord, "*");
        return closeSecretWord;
    }

    private static void print(String[] array) {
        for (String s : array) {
            if (s != null) {
                System.out.print(s + " ");
            }
        }
        System.out.println();
    }

    private static boolean isWon(String[] closeSecretWord, String[] secretWord) {
        return Arrays.equals(closeSecretWord, secretWord);
    }

    private static String inputLetter(Scanner scanner) {
        return scanner.nextLine().toLowerCase();
    }

    private static boolean isCyrillic(String letter) {
        return letter.matches("[^а-яА-Я]");
    }

    private static boolean isRepeat(String[] letterInputPlayer, String letter) {
        for (String s : letterInputPlayer) {
            if (s == null) continue;
            if (s.equals(letter)) return true;
        }
        return false;
    }

    private static void addAllLetter(String letter, String[] letterInputPlayer) {
        for (int i = 0; i < letterInputPlayer.length; i++) {
            if (letterInputPlayer[i] != null) continue;
            letterInputPlayer[i] = letter;
            return;
        }
    }

    private static boolean checkInputLetter(String letter, String[] secretWord, String[] closeSecretWord) {
        boolean hasLetter = false;
        for (int i = 0; i < secretWord.length; i++) {
            if (letter.equals(secretWord[i])) {
                closeSecretWord[i] = letter;
                hasLetter = true;
            }
        }
        return hasLetter;
    }

    private static int calcAttemps(boolean hasLetter, int errorCount) {
        if (hasLetter && errorCount != 0) {
            return --errorCount;
        } else if (!hasLetter && errorCount < ATTEMPS) {
            return ++errorCount;
        }
        return errorCount;
    }

    private static void printGallows(int errorCount, String[] pictureGallows) {
        for (int i = 1; i <= errorCount; i++) {
            System.out.println(pictureGallows[i - 1]);
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
}
