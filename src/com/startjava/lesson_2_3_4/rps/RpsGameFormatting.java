package com.startjava.lesson_2_3_4.rps;

import java.util.Random;
import java.util.Scanner;

        // Игра Камень-Ножницы_Бумага
public class RpsGameFormatting {

    private static final String ROCK = "R";
    private static final String SCISSORS = "S";
    private static final String PAPER = "P";

    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        Scanner console = new Scanner(System.in);
        String name1 = inputName(console);
        String name2 = inputName(console);

        // Ход первого игрока
        int position = generatePosition(name1, r);
        String sign1 = defineSign(position);
        showSigns(sign1);

        // Ход второго игрока
        position = generatePosition(name2, r);
        String sign2 = defineSign(position);
        showSigns(sign2);

        defineWinner(name1, sign1, name2, sign2);
    }

    private static String inputName(Scanner console) {
        return console.next();
    }
    private static int generatePosition(String name1, Random r) {
        System.out.println("Ход " + name1 + ": ");
        return r.nextInt(1, 100);
    }

    private static String defineSign(int position) {
        String sign = ROCK;
        if (position > 66) {
            sign = SCISSORS;
        }
        else if (position < 33) {
            sign = PAPER;
        }
        return sign;
    }
    private static void showSigns(String sign) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.print(ROCK + "\r");
                Thread.sleep(100);
            System.out.print(SCISSORS + "\r");
                Thread.sleep(100);
            System.out.print(PAPER + "\r");
                Thread.sleep(100);
        }
        System.out.println(sign);
    }

    private static void defineWinner(String name1, String sign1, String name2, String sign2) {
        if (sign1.equals(sign2)) {
        System.out.println("\nПобедила дружба!");
            return;
        }
        boolean isEqualName1 = sign1.equals(ROCK) && sign2.equals(SCISSORS) || sign1.equals(SCISSORS) && 
                sign2.equals(PAPER) || sign1.equals(PAPER) && sign2.equals(ROCK);

        if (isEqualName1) {
            System.out.println("\nПобедил - " + name1   );
        } else {
            System.out.println("\nПобедил - " + name2)  ;
        }
    }
}