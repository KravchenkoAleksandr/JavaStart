package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    static final int ATTEMPTS = 3;
    private String name;
    private int[] enteredNumbers = new int[ATTEMPTS];
    private int attempt;
    private int numberPoints;

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

    public int getNumberPoints() {
        return numberPoints;
    }

    public void setNumberPoints(int numberPoints) {
        this.numberPoints += numberPoints;
    }

    void addNumber(int number) {
        if (number >= 1 && number <= 100) {
            enteredNumbers[attempt] = number;
        }
    }

    int takeLastEnteredNum() {
        int num = enteredNumbers[attempt];
        attempt++;
        return num;
    }

    void clear() {
        Arrays.fill(enteredNumbers, 0, attempt, 0);
        attempt = 0;
    }
}

