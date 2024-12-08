package com.startjava.graduation.bookshelf;

import java.util.Scanner;

public class BookshelfTest {

    private static final int RANGE_START_MENU = 1;
    private static final int RANGE_END_MENU = 5;
    private static final String CONTINUE = "Для продолжения работы нажмите клавишу <Enter>";

    public static void main(String[] args) throws InterruptedException {
        Scanner scn = new Scanner(System.in);
        Bookshelf bookshelf = new Bookshelf();
        String action = "Да";
        textGreeting();
        while (action.equals("Да") || action.equals("Пуст")) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу");
            System.out.println(CONTINUE);
            scn.nextLine();
            while (true) {
                viewMenu();
                System.out.println("Введите пункт меню:");
                int pointMenu = enterMenuPoint(scn);
                try {
                    action = performActionForMenu(pointMenu, bookshelf, scn);
                } catch (RuntimeException e) {
                    System.out.println("Не удалось выполнить операцию");
                }
                if (action.equals("Пуст")) break;
                if (action.equals("Нет")) break;
                System.out.println(CONTINUE);
                scn.nextLine();
                bookshelf.viewCurrBooksCount();
                bookshelf.viewFreeShelfCount();
                bookshelf.viewBookshelf();
                System.out.println();
            }
        }
    }

    public static void textGreeting() throws InterruptedException {
        String text = "Добро пожаловать в приложение \"Книжный шкаф\"";
        String[] arrText = text.split(" ");
        for (String s : arrText) {
            for (char sign : s.toCharArray()) {
                System.out.print(sign);
                Thread.sleep(100);
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void viewMenu() {
        System.out.println("""
                1.Добавить книгу
                2.Удалить книгу
                3.Найти книгу по названию
                4.Очистить шкаф
                5.Завершить
                """);
    }

    private static int enterMenuPoint(Scanner scn) {
        while (true) {
            try {
                String inputText = scn.nextLine().trim();
                int input = Integer.parseInt(inputText);
                boolean isValid = isValidPointMenu(input);
                if (isValid) return input;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите номер из списка:");
            }
        }
    }

    private static boolean isValidPointMenu(int input) {
        return input >= RANGE_START_MENU && input <= RANGE_END_MENU;
    }

    private static String performActionForMenu(int pointMenu, Bookshelf bookshelf, Scanner scn) {
        switch (pointMenu) {
            case 1 -> {
                System.out.println("Вы выбрали добавить книгу.");
                addBook(bookshelf, scn);
            }
            case 2 -> {
                System.out.println("Вы выбрали удалить книгу.");
                deleteBook(bookshelf, scn);
                if (bookshelf.getCurrBooksCount() == 0) return "Пуст";
            }
            case 3 -> {
                System.out.println("Вы выбрали найти книгу по названию.");
                findBook(bookshelf, scn);
            }
            case 4 -> {
                System.out.println("Вы выбрали очистить шкаф.");
                bookshelf.clear();
                System.out.println("Шкаф очищен.");
                return "Пуст";
            }
            case 5 -> {
                return "Нет";
            }
            default -> System.out.println("Нет подходящего пункта меню");
        }
        return "Да";
    }

    private static void addBook(Bookshelf bookshelf, Scanner scn) {
        System.out.println("Введите автора книги:");
        String author = scn.nextLine().trim();
        System.out.println("Введите название книги:");
        String title = scn.nextLine().trim();
        System.out.println("Введите год издания книги:");
        int yearProduction;
        while (true) {
            try {
                yearProduction = Integer.parseInt(scn.nextLine().trim());
                Book book1 = new Book(author, title, yearProduction);
                boolean isAdded = bookshelf.add(book1);
                if (isAdded) {
                    System.out.println("Книга добавлена");
                } else if (bookshelf.getCurrBooksCount() == Bookshelf.MAX_TOTAL_BOOKS) {
                    System.out.println("Не удалось добавить книгу.В книжном шкафу закончилось место");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Введите год издания книги цифрами");
            }
        }
    }

    private static void deleteBook(Bookshelf bookshelf, Scanner scn) {
        System.out.println("Введите название книги, которую хотите удалить:");
        String title = scn.nextLine().trim();
        boolean isRemoved = bookshelf.delete(title);
        if (isRemoved) {
            System.out.println("Книга " + title + " удалена.");
        } else {
            System.out.println("Не удалось удалить книгу " + title);
        }
    }

    private static void findBook(Bookshelf bookshelf, Scanner scn) {
        System.out.println("Введите название книги");
        String title = scn.nextLine().trim();
        Book bookByTitle = bookshelf.findByTitle(title);
        if (bookByTitle != null) {
            System.out.println("По названию найдены следующие книги: ");
            printFoundBooks(bookByTitle);
        } else {
            System.out.println("Книга не найдена");
        }
    }

    private static void printFoundBooks(Book foundBook) {
        System.out.println(foundBook.toString());
    }
}