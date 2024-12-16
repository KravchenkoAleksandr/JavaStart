package com.startjava.graduation.bookshelf;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfTest {

    private static final int RANGE_MENU_START = 1;
    private static final int RANGE_MENU_END = 5;

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Bookshelf bookshelf = new Bookshelf();
        String action = "START";
        printTextGreeting();
        while (!action.equals("EXIT")) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу\n");
            while (true) {
                viewMenu();
                System.out.println("Введите пункт меню:");
                int menuPoint = enterMenuPoint(sc);
                Menu currMenuPoint = menuItem(menuPoint);
                action = execAction(currMenuPoint, sc, bookshelf);
                if (action.equals("EXIT")) break;
                inputEnter(sc);
                if (bookshelf.getBooksCount() == 0) break;
                viewCurrBooksCount(bookshelf);
                viewFreeShelfCount(bookshelf);
                viewBookshelf(bookshelf);
                System.out.println();
            }
        }
    }

    private static void printTextGreeting() throws InterruptedException {
        String msg = "Добро пожаловать в приложение \"Книжный шкаф\"";
        String[] splittedMsg = msg.split(" ");
        for (String s : splittedMsg) {
            for (char ch : s.toCharArray()) {
                System.out.print(ch);
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

    private static int enterMenuPoint(Scanner sc) {
        while (true) {
            int input;
            try {
                input = sc.nextInt();
                if (!isValidMenuPoint(input)) {
                    throw new IllegalArgumentException();
                }
                return input;
            } catch (RuntimeException e) {
                System.out.println("Ошибка: введите номер из списка:");
                sc.nextLine();
            }
        }
    }

    private static boolean isValidMenuPoint(int input) {
        return input >= RANGE_MENU_START && input <= RANGE_MENU_END;
    }

    private static Menu menuItem(int menuPoint) {
        return Menu.chooseMenu(menuPoint);
    }

    private static String execAction(Menu menu, Scanner sc, Bookshelf bookshelf) {
        switch (menu) {
            case ADD -> {
                System.out.println("Вы выбрали добавить книгу.");
                addBook(bookshelf, sc);
                sc.nextLine();
            }
            case DELETE -> {
                System.out.println("Вы выбрали удалить книгу.");
                sc.nextLine();
                deleteBook(bookshelf, sc);
            }
            case FIND -> {
                System.out.println("Вы выбрали найти книгу по названию.");
                sc.nextLine();
                findBook(bookshelf, sc);
            }
            case CLEAR -> {
                System.out.println("Вы выбрали очистить шкаф.");
                sc.nextLine();
                bookshelf.clear();
                System.out.println("Шкаф очищен.");
                return "ERROR";
            }
            case EXIT -> {
                return "EXIT";
            }
            default -> System.out.println("Нет подходящего пункта меню");
        }
        return "ERROR";
    }

    private static void addBook(Bookshelf bookshelf, Scanner sc) {
        if (bookshelf.getBooksCount() >= Bookshelf.TOTAL_BOOKS) {
            System.out.println("Невозможно добавить книгу.В книжном шкафу закончилось место");
            return;
        }
        System.out.println("Введите автора книги:");
        sc.nextLine();
        String author = sc.nextLine().trim();
        String title = inputBookTitle(sc);
        System.out.println("Введите год издания книги:");
        while (true) {
            try {
                int published = sc.nextInt();
                Book book = new Book(author, title, published);
                bookshelf.add(book);
                System.out.println("Книга добавлена");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введите год издания книги цифрами");
                sc.nextLine();
            }
        }
    }

    private static void deleteBook(Bookshelf bookshelf, Scanner sc) {
        if (bookshelf.getBooksCount() == 0) {
            System.out.println("Шкаф пуст. Невозможно удалить книгу");
            return;
        }
        String title = inputBookTitle(sc);
        try {
            bookshelf.delete(title);
            System.out.println("Книга " + title + " удалена.");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void findBook(Bookshelf bookshelf, Scanner sc) {
        if (bookshelf.getBooksCount() == 0) {
            System.out.println("Шкаф пуст. Невозможно найти книгу");
            return;
        }
        String title = inputBookTitle(sc);
        try {
            Book foundBook = bookshelf.find(title);
            System.out.println("По названию найдены следующие книги: ");
            printFoundBooks(foundBook);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String inputBookTitle(Scanner sc) {
        System.out.println("Введите название книги");
        return sc.nextLine().trim();
    }

    private static void printFoundBooks(Book foundBook) {
        System.out.println(foundBook);
    }

    private static void inputEnter(Scanner sc) {
        String input = "not empty";
        while (!input.isEmpty()) {
            System.out.println("Для продолжения работы нажмите клавишу <Enter>");
            input = sc.nextLine();
        }
    }

    private static void viewCurrBooksCount(Bookshelf bookshelf) {
        System.out.print("В шкафу книг - " + bookshelf.getBooksCount());
    }

    private static void viewFreeShelfCount(Bookshelf bookshelf) {
        int freeShelfCount = Bookshelf.TOTAL_BOOKS - bookshelf.getBooksCount();
        System.out.println(", свободно полок - " + freeShelfCount + "\n");
    }

    private static void viewBookshelf(Bookshelf bookshelf) {
        for (Book book : bookshelf.getBooks()) {
            if (book == null) return;
            StringBuilder sb = new StringBuilder("|");
            int max = bookshelf.getMaxLength();
            int spaceNum = max - book.toString().length();
            sb.append(book).repeat(" ", spaceNum).append("|").append("\n|").repeat("-", max).append("|");
            System.out.println(sb);
        }
    }
}
