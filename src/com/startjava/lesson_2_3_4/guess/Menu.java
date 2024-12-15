package com.startjava.lesson_2_3_4.guess;

public enum Menu {
    ADD(1),
    DELETE(2),
    FIND(3),
    CLEAR(4),
    FINISH(5);

    public final int menuPoint;

    Menu(int menuPoint) {
        this.menuPoint = menuPoint;
    }
}
