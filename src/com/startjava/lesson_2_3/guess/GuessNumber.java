package com.startjava.lesson_2_3.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    private static final int MAX_ATTEMPTS = 10;
    private Player player1;
    private Player player2;
    private int inputNumber;
    private int secretNumber;

    public GuessNumber(String namePlayer1, String namePlayer2) {
        player1 = new Player(namePlayer1);
        player2 = new Player(namePlayer2);
    }

    public void start() {
        player1.setAttempts(0);
        player2.setAttempts(0);
        System.out.println("Игра началась! У каждого игрока по " + MAX_ATTEMPTS + " попыток.\n");
        thinkSecretNumber();
        boolean isGameOver = false;
        int countAttempts = 0;
        while (!isGameOver) {
            if (isMoveSuccessful(player1)) {
                break;
            }
            isGameOver = isMoveSuccessful(player2);
            countAttempts++;
            if (countAttempts == MAX_ATTEMPTS) break;
        }
        int[] outputNumbersPlayer1 = player1.getEnteredNumbers();
        int[] outputNumbersPlayer2 = player2.getEnteredNumbers();
        print(outputNumbersPlayer1, player1);
        print(outputNumbersPlayer2, player2);
        player1.cleanArrayEnteredNumbers();
        player2.cleanArrayEnteredNumbers();
    }

    private void thinkSecretNumber() {
        secretNumber = random.nextInt(0, 101);
    }

    private boolean isMoveSuccessful(Player player) {
        int inputNumberPlayer;
        if (player.getAttempts() < MAX_ATTEMPTS) {
            inputNumberPlayer = inputNumberPlayer(player, player.getAttempts());
            player.setEnteredNumbers(player.getAttempts() - 1, inputNumberPlayer);
            printAttempts(player);
            return isGuessed(player);
        } else {
            printAttempts(player);
        }
        return false;
    }

    private int inputNumberPlayer(Player player, int attempts) {
        if (attempts > MAX_ATTEMPTS) {
            return -1;
        } else {
            System.out.println(player.getName() + " введите число");
            inputNumber = scanner.nextInt();
            player.setAttempts(++attempts);
        }
        return inputNumber;
    }

    private boolean isGuessed(Player player) {
        if (inputNumber == secretNumber) {
            System.out.println("Игрок " + player.getName() + " угадал число " + secretNumber + " с " + player.getAttempts()
                    + "-й попытки и победил!\n");
            return true;
        }
        String text = inputNumber > secretNumber ? " больше" : " меньше";
        System.out.printf("Число %d%s того, что загадал компьютер %n%n", inputNumber, text);
        return false;
    }

    private void printAttempts(Player player) {
        System.out.println("Количество использованных попыток: " + player.getAttempts());
    }

    private void print(int[] array, Player player) {
        System.out.print("Числа введенные игроком " + player.getName() + ": ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

