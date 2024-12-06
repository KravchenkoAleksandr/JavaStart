package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumTest {

    private static final int PLAYERS_NUM = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player[] players = createPlayers(scanner);
        GuessNum game = new GuessNum(players);
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

    private static Player[] createPlayers(Scanner scanner) {
        Player[] players = new Player[PLAYERS_NUM];
        for (int i = 0; i < players.length; i++) {
            System.out.println("Введите имя игрока номер " + (i + 1));
            String playerName = scanner.nextLine();
            players[i] = new Player(playerName);
        }
        return players;
    }
}