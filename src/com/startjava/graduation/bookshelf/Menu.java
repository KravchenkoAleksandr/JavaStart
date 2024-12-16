package com.startjava.graduation.bookshelf;

public enum Menu {
    ADD(1),
    DELETE(2),
    FIND(3),
    CLEAR(4),
    EXIT(5);

    public final int menuPoint;

    Menu(int menuPoint) {
        this.menuPoint = menuPoint;
    }

    public static Menu chooseMenu(int menuPoint) {
        if (ADD.menuPoint == menuPoint) {
            return ADD;
        } else if (DELETE.menuPoint == menuPoint) {
            return DELETE;
        } else if (FIND.menuPoint == menuPoint) {
            return FIND;
        } else if (CLEAR.menuPoint == menuPoint) {
            return CLEAR;
        } else if (EXIT.menuPoint == menuPoint) {
            return EXIT;
        }
        throw new IllegalArgumentException("Ошибка: введите номер из списка:");
    }
}

