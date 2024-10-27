package com.startjava.lesson_2_3.guess;

import java.util.Arrays;

public class Player {

    private String name;
    private int[] enteredNumbers = new int[10];
    private int attempts;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] getEnteredNumbers() {
        return enteredNumbers;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    int[] takingInputNumbers(int[] enteredNumbers, int attempts) {
        return Arrays.copyOf(enteredNumbers, attempts);
    }

    void cleanArrayEnteredNumbers(int[] enteredNumbers, int[] arrayInputNumbers) {
        Arrays.fill(enteredNumbers, 0, arrayInputNumbers.length, 0);
    }
}
