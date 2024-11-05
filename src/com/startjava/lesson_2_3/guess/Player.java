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
        return Arrays.copyOf(enteredNumbers, attempts);
    }

    public void setEnteredNumbers(int index, int value) {
        if (index >= 0 && index < enteredNumbers.length) {
        enteredNumbers[index] = value;
        }
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    void cleanArrayEnteredNumbers() {
        Arrays.fill(enteredNumbers, 0, getEnteredNumbers().length, 0);
    }
}

