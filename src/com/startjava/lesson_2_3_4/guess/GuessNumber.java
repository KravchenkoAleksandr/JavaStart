package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

import static com.startjava.lesson_2_3_4.guess.Player.ATTEMPTS;

public class GuessNumber {

    static final int NUMBER_PLAYERS = 3;
    static final int NUMBER_ROUND = 3;
    static final int POINT_FOR_WINS = 3;
    static final int POINT_FOR_DRAW = 0;

    int counterRounds = 1;
    private Player[] players;
    private int secretNumber;

    public GuessNumber(Player[] players) {
        this.players = players;
    }

    public void start() {
        determineFirstMove();
        System.out.println("Жребий брошен! Игроки ходят в следующем порядке: ");
        for (Player player : players) {
            System.out.println(player.getName());
        }
        while (counterRounds <= NUMBER_ROUND) {
            playRound();
        }
        findGameWinner();
    }

    private void determineFirstMove() {
        Random rnd = new Random();
        int lastIndex = players.length - 1;
        for (int i = 0; i < players.length; i++) {
            int rndNum = rnd.nextInt(players.length - i);
            Player tmp = players[lastIndex];
            players[lastIndex] = players[rndNum];
            players[rndNum] = tmp;
        }
    }

    private void playRound() {
        Random random = new Random();
        System.out.println("\nРаунд № " + counterRounds + ". У каждого игрока по " + ATTEMPTS + " попыток.\n");
        thinkSecretNumber(random);
        System.out.println(secretNumber);
        boolean isWon = true;
        int countAttempts = 0;
        while (isWon) {
            for (Player player : players) {
                if (isMoveSuccessful(player)) {
                    player.setNumberPoints(POINT_FOR_WINS);
                    counterRounds++;
                    isWon = false;
                    break;
                }
            }
            countAttempts++;
            if (countAttempts == ATTEMPTS && isWon) {
                System.out.println("В раунде ничья!\n");
                for (Player player : players) {
                    player.setNumberPoints(POINT_FOR_DRAW);
                }
                counterRounds++;
                break;
            }
        }
        for (Player player : players) {
            printEnteredNumber(player);
            System.out.println("Количество очков: " + player.getNumberPoints());
            player.clear();
        }
    }

    private void findGameWinner() {
        int maxPoints = 0;
        for (Player value : players) {
            if (maxPoints < value.getNumberPoints()) {
                maxPoints = value.getNumberPoints();
            }
        }
        if (maxPoints == 0) {
            System.out.println("\nНичья!");
            return;
        }
        for (Player player : players) {
            if (player.getNumberPoints() == maxPoints) {
                System.out.println("\nПобедил игрок: " + player.getName() + "\nНабранное количество очков: " + maxPoints);
            }
        }
    }

    private void thinkSecretNumber(Random random) {
        secretNumber = random.nextInt(0, 101);
    }

    private boolean isMoveSuccessful(Player player) {
        Scanner scanner = new Scanner(System.in);
        if (player.getAttempt() < ATTEMPTS) {
            inputPlayerNumber(player, scanner);
            int inputNum = player.takeLastEnteredNum();
            System.out.print("Игрок: " + player.getName());
            printAttempts(player.getAttempt());
            return isGuessed(player, inputNum);
        }
        printAttempts(player.getAttempt());
        return false;
    }

    private void inputPlayerNumber(Player player, Scanner scanner) {
        if (player.getAttempt() < ATTEMPTS) {
            int inputNum = 0;
            System.out.println(player.getName() + " введите число");
            boolean isValid = true;
            while (isValid) {
                inputNum = scanner.nextInt();
                isValid = checkNum(inputNum);
            }
            player.addNumber(inputNum);
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
                    + "-й попытки и победил в " + counterRounds + " раунде!\n");
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

