package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    static final int ATTEMPTS = 10;
    private String name;
    private int[] enteredNumbers = new int[ATTEMPTS];
    private int attempt;
    private int numberWins;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] getEnteredNumbers() {
        return Arrays.copyOf(enteredNumbers, attempt);
    }

    public int getAttempt() {
        return attempt;
    }

    public int getNumberWins() {
        return numberWins;
    }

    public void setNumberWins(int numberWins) {
        this.numberWins += numberWins;
    }

    void addNumber(int number) {
        if (number >= 1 && number <= 100) {
            enteredNumbers[attempt] = number;
        }
        attempt++;
    }

    int takeLastEnteredNum() {
        return enteredNumbers[attempt];
    }

    void clear() {
        Arrays.fill(enteredNumbers, 0, attempt, 0);
        attempt = 0;
    }
}

