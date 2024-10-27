package com.startjava.lesson_2_3.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    private final int MAX_ATTEMPTS = 10;
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
        do {
            if (player1.getAttempts() < MAX_ATTEMPTS) {
                int enteredNumberPLayer1 = inputNumberPlayer(player1, player1.getAttempts());
                addNumber(player1.getEnteredNumbers(), enteredNumberPLayer1);
                printAttempts(player1);
                if (isGuessed(player1)) {
                    break;
                }
            } else {
                printAttempts(player1);
            }
            if (player2.getAttempts() < MAX_ATTEMPTS) {
                int enteredNumberPLayer2 = inputNumberPlayer(player2, player2.getAttempts());
                addNumber(player2.getEnteredNumbers(), enteredNumberPLayer2);
                printAttempts(player2);
                if (isGuessed(player2)) {
                    isGameOver = true;
                }
            } else {
                printAttempts(player2);
            }
            if (player1.getAttempts() == MAX_ATTEMPTS && player2.getAttempts() == MAX_ATTEMPTS && !isGameOver) {
                System.out.println("У игроков закончились попытки!");
                break;
            }
        } while (!isGameOver);
        int[] outputNumbersPlayer1 = player1.takingInputNumbers(player1.getEnteredNumbers(), player1.getAttempts());
        int[] outputNumbersPlayer2 = player2.takingInputNumbers(player2.getEnteredNumbers(), player2.getAttempts());
        print(outputNumbersPlayer1, player1);
        print(outputNumbersPlayer2, player2);
        player1.cleanArrayEnteredNumbers(player1.getEnteredNumbers(), outputNumbersPlayer1);
        player2.cleanArrayEnteredNumbers(player2.getEnteredNumbers(), outputNumbersPlayer2);
    }

    private void thinkSecretNumber() {
        secretNumber = random.nextInt(0, 101);
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

    private void addNumber(int[] player, int inputNumber) {
        if (inputNumber == -1) return;
        for (int i = 0; i < player.length; i++) {
            if (player[i] == 0) {
                player[i] = inputNumber;
                return;
            }
        }
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

