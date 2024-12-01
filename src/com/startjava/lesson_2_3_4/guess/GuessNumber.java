package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

import static com.startjava.lesson_2_3_4.guess.Player.ATTEMPTS;

public class GuessNumber {

    static final int NUMBER_PLAYERS = 3;
    private Player[] players = new Player[NUMBER_PLAYERS];
    private int secretNumber;

    public GuessNumber(Player[] players) {
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            players[i] = new Player(players[i].getName());
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public void start() {
        Random random = new Random();
        for (Player player : players) {
            player.clear();
        }
        System.out.println("Игра началась! У каждого игрока по " + ATTEMPTS + " попыток.\n");
        thinkSecretNumber(random);
        boolean isWon = false;
        int countAttempts = 0;
        while (!isWon) {
            if (isMoveSuccessful(player1)) break;
            isWon = isMoveSuccessful(player2);
            countAttempts++;
            if (countAttempts == ATTEMPTS) break;
        }
        printEnteredNumber(player1);
        printEnteredNumber(player2);
    }

    private void thinkSecretNumber(Random random) {
        secretNumber = random.nextInt(0, 101);
    }

    private boolean isMoveSuccessful(Player player) {
        Scanner scanner = new Scanner(System.in);
        if (player.getAttempt() < ATTEMPTS) {
            inputNumberPlayer(player, scanner);
            System.out.print("Игрок: " + player.getName());
            printAttempts(player.getAttempt());
            return isGuessed(player, player.getEnteredNumbers()[player.getAttempt() - 1]);
        }
        printAttempts(player.getAttempt());
        return false;
    }

    private void inputNumberPlayer(Player player, Scanner scanner) {
        if (player.getAttempt() < ATTEMPTS) {
            int inputNumber = 0;
            System.out.println(player.getName() + " введите число");
            boolean isValid = true;
            while (isValid) {
                inputNumber = scanner.nextInt();
                isValid = checkNum(inputNumber);
            }
            player.addNumber(inputNumber);
        }
    }

    private boolean checkNum(int inputNum) {
        if (inputNum < 1 || inputNum > 100) {
            System.out.println("Число должно входить в отрезок [1, 100].\n" +
                    "Попробуйте еще раз:");
            return true;
        }
        return false;
    }

    private boolean isGuessed(Player player, int inputNumber) {
        if (inputNumber == secretNumber) {
            System.out.println("Игрок " + player.getName() + " угадал число " + secretNumber + " с " + player.getAttempt()
                    + "-й попытки и победил!\n");
            return true;
        }
        String text = inputNumber > secretNumber ? " больше" : " меньше";
        System.out.printf("Число %d%s того, что загадал компьютер %n%n", inputNumber, text);
        return false;
    }

    private void printAttempts(int attempt) {
        System.out.println(" - количество использованных попыток: " + attempt);
    }

    private void printEnteredNumber(Player player) {
        System.out.print("Числа введенные игроком " + player.getName() + ": ");
        for (int i : player.getEnteredNumbers()) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

