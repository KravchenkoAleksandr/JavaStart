package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;
import static com.startjava.lesson_2_3_4.guess.GuessNumber.NUMBER_PLAYERS;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя первого игрока");
        String namePlayer1 = scanner.nextLine();
        System.out.println("Введите имя второго игрока");
        String namePlayer2 = scanner.nextLine();
        //GuessNumber game = new GuessNumber();
        String answer = "yes";
        while (!answer.equals("no")) {
            if (answer.equals("yes")) {
                //game.start();
                System.out.println("Хотите продолжить игры? [yes / no]:");
            } else {
                System.out.println("Введите корректный ответ [yes / no]:");
            }
            answer = scanner.nextLine().toLowerCase();
        }
    }

    private static Player[] createPlayers() {
        for (int i = 0; i < ; i++) {

        }
    }
}