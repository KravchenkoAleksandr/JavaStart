package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNum {

    private static final int ROUND_NUM = 3;
    private static final int WIN_POINT = 1;
    static final int rangeStart = 1;
    static final int rangeEnd = 100;


    private int roundsCounter = 1;
    private final Player[] players;
    private int secretNum;

    public GuessNum(Player[] players) {
        this.players = players;
    }

    public void start() {
        Random rnd = new Random();
        shufflePlayers(rnd);
        System.out.println("Жребий брошен! Игроки ходят в следующем порядке: ");
        for (Player player : players) {
            System.out.println(player.getName());
        }
        while (roundsCounter <= ROUND_NUM) {
            playRound(rnd);
        }
        findGameWinner();
    }

    private void shufflePlayers(Random rnd) {
        int lastIndex = players.length - 1;
        for (int i = 0; i < players.length; i++) {
            int rndNum = rnd.nextInt(players.length - i);
            Player tmp = players[lastIndex];
            players[lastIndex] = players[rndNum];
            players[rndNum] = tmp;
        }
    }

    private void playRound(Random rnd) {
        System.out.println("\nРаунд № " + roundsCounter + ". У каждого игрока по " + Player.ATTEMPTS + " попыток.\n");
        thinkSecretNum(rnd);
        boolean isWon = true;
        int attemptsCount = 0;
        while (isWon) {
            for (Player player : players) {
                if (isMoveSuccessful(player)) {
                    player.setWinsCount(WIN_POINT);
                    roundsCounter++;
                    isWon = false;
                    break;
                }
            }
            attemptsCount++;
            if (attemptsCount == Player.ATTEMPTS && isWon) {
                roundsCounter++;
                break;
            }
        }
        printEnteredNums(players);
    }

    private void thinkSecretNum(Random random) {
        secretNum = random.nextInt(0, rangeEnd + 1);
    }

    private boolean isMoveSuccessful(Player player) {
        Scanner scanner = new Scanner(System.in);
        if (player.getAttempt() < Player.ATTEMPTS) {
            int inputNum = inputPlayerNum(player, scanner);
            player.addNum(inputNum);
            System.out.print("Игрок: " + player.getName());
            printTotalAttempts(player.getAttempt());
            return isGuessed(player, inputNum);
        }
        printTotalAttempts(player.getAttempt());
        return false;
    }

    private int inputPlayerNum(Player player, Scanner scanner) {
        String inputNum;
        int num = 0;
        System.out.println(player.getName() + " введите число");
        boolean isValid = false;
        while (!isValid) {
            inputNum = scanner.nextLine();
            try {
                num = Integer.parseInt(inputNum);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не целое число.");
            }
            isValid = isValidNum(num);
            if (!isValid) {
                System.out.println("Число должно входить в отрезок [" + rangeStart + "," + rangeEnd + ".\n" +
                        "Попробуйте еще раз:");
            }
        }
        return num;
    }

    private boolean isValidNum(int inputNum) {
        return inputNum >= rangeStart && inputNum <= rangeEnd;
    }

    private void printTotalAttempts(int attempt) {
        System.out.println(" - количество использованных попыток: " + attempt);
    }

    private boolean isGuessed(Player player, int inputNum) {
        if (inputNum == secretNum) {
            System.out.println("Игрок " + player.getName() + " угадал число " + secretNum + " с " + player.getAttempt()
                    + "-й попытки и победил в " + roundsCounter + " раунде!\n");
            return true;
        }
        String text = inputNum > secretNum ? " больше" : " меньше";
        System.out.printf("Число %d%s того, что загадал компьютер %n%n", inputNum, text);
        return false;
    }

    private void printEnteredNums(Player[] players) {
        for (Player player : players) {
            System.out.print("\nЧисла введенные игроком " + player.getName() + ": ");
            for (int n : player.getEnteredNums()) {
                System.out.print(n + " ");
            }
            System.out.println("\nКоличество очков: " + player.getWinsCount());
            player.clear();
        }
    }

    private void findGameWinner() {
        int maxPoints = 0;
        for (Player player : players) {
            if (maxPoints < player.getWinsCount()) {
                maxPoints = player.getWinsCount();
            }
        }
        if (maxPoints == 0) {
            System.out.println("Ничья!");
            return;
        }
        for (Player player : players) {
            if (player.getWinsCount() == maxPoints) {
                System.out.println("\nПобедил игрок: " + player.getName() + "\nНабранное количество очков: " + maxPoints);
            }
        }
    }
}

