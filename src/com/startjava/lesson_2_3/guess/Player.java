package com.startjava.lesson_2_3.guess;

import java.util.Arrays;

public class Player {

    private static final int ATTEMPTS = 10;
    private String name;
    private int[] enteredNumbers = new int[ATTEMPTS];
    int attempts;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] getEnteredNumbers() {
        return Arrays.copyOf(enteredNumbers, attempts);
    }

    public int getAttempts() {
        return attempts;
    }

    public void addNumber(int index, int number) {
        enteredNumbers[index] = number;
    }

    void clear() {
        Arrays.fill(enteredNumbers, 0, attempts, 0);
        attempts = 0;
    }
}

