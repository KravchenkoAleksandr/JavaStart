package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

import static com.startjava.lesson_2_3_4.guess.GuessNumber.NUMBER_PLAYERS;

public class GuessNumberTest {
    public static void main(String[] args) {
        Player[] players = new Player[NUMBER_PLAYERS];
        Scanner scanner = new Scanner(System.in);
        createPlayers(players, scanner);
        GuessNumber game = new GuessNumber(players);
        String answer = "yes";
        while (!answer.equals("no")) {
            if (answer.equals("yes")) {
                game.start();
                System.out.println("Хотите продолжить игру? [yes / no]:");
            } else {
                System.out.println("Введите корректный ответ [yes / no]:");
            }
            answer = scanner.nextLine().toLowerCase();
        }
    }

    private static void createPlayers(Player[] players, Scanner scanner) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Введите имя игрока номер " + (i + 1));
            String namePlayer = scanner.nextLine();
            players[i] = new Player(namePlayer);
        }
    }
}