package com.startjava.graduation.bookshelf;

public enum Menu {
    ADD(1),
    DELETE(2),
    FIND(3),
    CLEAR(4),
    EXIT(5);

    private final int menuPoint;

    Menu(int menuPoint) {
        this.menuPoint = menuPoint;
    }

    public int getMenuPoint() {
        return menuPoint;
    }

    public static Menu chooseMenu(int menuPoint) {
        if (menuPoint < BookshelfTest.RANGE_MENU_START || menuPoint > BookshelfTest.RANGE_MENU_END) {
            throw new IllegalArgumentException("Ошибка: введите номер из списка:");
        }
        return Menu.values()[menuPoint - 1];
    }
}

