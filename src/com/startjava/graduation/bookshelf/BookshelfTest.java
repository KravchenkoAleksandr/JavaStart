package com.startjava.graduation.bookshelf;

import com.startjava.lesson_2_3_4.guess.Menu;
import com.startjava.lesson_2_3_4.guess.NotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfTest {

    private static final int RANGE_MENU_START = 1;
    private static final int RANGE_MENU_END = 5;
    private static final String CONTINUE = "Для продолжения работы нажмите клавишу <Enter>";

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Bookshelf bookshelf = new Bookshelf();
        String action = "Да";
        printTextGreeting();
        while (action.equals("Да") || action.equals("Пуст")) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу\n");
            while (true) {
                viewMenu();
                System.out.println("Введите пункт меню:");
                int menuDigit = enterMenuPoint(sc);
                Menu menuPoint = chooseMenu(menuDigit);
                action = execAction(menuPoint, sc, bookshelf);
                inputEnter(sc);
                if (action.equals("Пуст")) break;
                if (action.equals("Нет")) break;
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

    private static Menu chooseMenu(int menuDigit) {
        for (Menu menu : Menu.values()) {
            if (menu.menuPoint == menuDigit) {
                return menu;
            }
        }
        throw new IllegalArgumentException("Ошибка: введите номер из списка:");
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
                if (bookshelf.getBooksCount() == 0) return "Пуст";
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
                return "Пуст";
            }
            case FINISH -> {
                return "Нет";
            }
            default -> System.out.println("Нет подходящего пункта меню");
        }
        return "Да";
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

    private static String inputBookTitle(Scanner sc) {
        System.out.println("Введите название книги");
        return sc.nextLine().trim();
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
        inputEnter(sc);
        try {
            Book foundBook = bookshelf.find(title);
            System.out.println("По названию найдены следующие книги: ");
            printFoundBooks(foundBook);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void inputEnter(Scanner sc) {
        String input = "not empty";
        while (!input.isEmpty()) {
            System.out.println(CONTINUE);
            input = sc.nextLine();
        }
    }

    private static void printFoundBooks(Book foundBook) {
        System.out.println(foundBook);
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

    private static void viewCurrBooksCount(Bookshelf bookshelf) {
        System.out.print("В шкафу книг - " + bookshelf.getBooksCount());
    }

    private static void viewFreeShelfCount(Bookshelf bookshelf) {
        int freeShelfCount = Bookshelf.TOTAL_BOOKS - bookshelf.getBooksCount();
        System.out.println(", свободно полок - " + freeShelfCount + "\n");
    }
}
