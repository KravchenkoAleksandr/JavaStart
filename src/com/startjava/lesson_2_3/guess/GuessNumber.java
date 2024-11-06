package com.startjava.lesson_2_3.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

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
        Random random = new Random();
        player1.clear();
        player2.clear();
        System.out.println("Игра началась! У каждого игрока по " + MAX_ATTEMPTS + " попыток.\n");
        thinkSecretNumber(random);
        boolean isWon = false;
        int countAttempts = 0;
        while (!isWon) {
            if (isMoveSuccessful(player1)) {
                break;
            }
            isWon = isMoveSuccessful(player2);
            countAttempts++;
            if (countAttempts == MAX_ATTEMPTS) break;
        }
        printInputNumber(player1);
        printInputNumber(player2);
        player1.clear();
        player2.clear();
    }

    private void thinkSecretNumber(Random random) {
        secretNumber = random.nextInt(0, 101);
    }

    private boolean isMoveSuccessful(Player player) {
        Scanner scanner = new Scanner(System.in);
        if (player.getAttempts() < MAX_ATTEMPTS) {
            int inputNumberPlayer = inputNumberPlayer(player, scanner);
            player.addNumber(player.getAttempts() - 1, inputNumberPlayer);
            printAttempts(player);
            return isGuessed(player);
        }
        printAttempts(player);
        return false;
    }

    private int inputNumberPlayer(Player player, Scanner scanner) {
        if (player.attempts > MAX_ATTEMPTS) {
            return -1;
        }
        System.out.println(player.getName() + " введите число");
        inputNumber = scanner.nextInt();
        player.attempts++;
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

    private void printInputNumber(Player player) {
        System.out.print("Числа введенные игроком " + player.getName() + ": ");
        for (int i : player.getEnteredNumbers()) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

