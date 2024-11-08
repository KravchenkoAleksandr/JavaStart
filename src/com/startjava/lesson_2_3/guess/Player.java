package com.startjava.lesson_2_3.guess;

import java.util.Arrays;

public class Player {

    static final int ATTEMPTS = 10;
    private String name;
    private int[] enteredNumbers = new int[ATTEMPTS];
    private int attempt;
    private int inputNumber;

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

    public void setAttempt(int increment) {
        this.attempt += increment;
    }

    public int getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public void addNumber(int attempt, int number) {
        enteredNumbers[attempt] = number;
    }

    void clear() {
        Arrays.fill(enteredNumbers, 0, attempt, 0);
        attempt = 0;
    }
}

