package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    static final int ATTEMPTS = 10;
    private String name;
    private int[] enteredNumbers = new int[ATTEMPTS];
    private int attempt;

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

    public void setAttempt() {
        this.attempt++;
    }

    public void addNumber(int number) {
        enteredNumbers[attempt] = number;
    }

    void clear() {
        Arrays.fill(enteredNumbers, 0, attempt, 0);
        attempt = 0;
    }
}

