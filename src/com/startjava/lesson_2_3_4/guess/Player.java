package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    static final int ATTEMPTS = 10;
    private final String name;
    private final int[] enteredNums = new int[ATTEMPTS];
    private int attempt;
    private int winsCount;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] getEnteredNums() {
        return Arrays.copyOf(enteredNums, attempt);
    }

    public int getAttempt() {
        return attempt;
    }

    public int getWinsCount() {
        return winsCount;
    }

    public void setWinsCount(int winsCount) {
        this.winsCount += winsCount;
    }

    public void addNum(int num) {
        if (num >= GuessNum.RANGE_START && num <= GuessNum.RANGE_END) {
            enteredNums[attempt] = num;
        }
        attempt++;
    }

    public void clear() {
        Arrays.fill(enteredNums, 0, attempt, 0);
        attempt = 0;
    }
}

