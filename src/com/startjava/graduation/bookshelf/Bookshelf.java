package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    static final int MAX_TOTAL_BOOKS = 10;
    private int currBooksCount;
    private final Book[] books;

    public Bookshelf() {
        books = new Book[MAX_TOTAL_BOOKS];
    }

    public int getCurrBooksCount() {
        return currBooksCount;
    }

    public boolean add(Book book) {
        if (currBooksCount == MAX_TOTAL_BOOKS) return false;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                ++currBooksCount;
                return true;
            }
        }
        return false;
    }

    public boolean delete(String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals(title)) {
                int numberOfElements = currBooksCount - (i + 1);
                System.arraycopy(books, i + 1, books, i, numberOfElements);
                books[currBooksCount - 1] = null;
                --currBooksCount;
                return true;
            }
        }
        return false;
    }

    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book == null) break;
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void clear() {
        Arrays.fill(books, 0, MAX_TOTAL_BOOKS, null);
        currBooksCount = 0;
    }

    void viewBookshelf() {
        int maxLength = findMaxLengthBookshelf();
        for (Book book : books) {
            if (book == null) return;
            String pipe = "|".repeat(1);
            System.out.print(pipe);
            System.out.print(book);
            int len = maxLength - book.toString().length();
            String emptySpace = " ".repeat(len);
            System.out.print(emptySpace);
            System.out.println(pipe);
            System.out.print(pipe);
            String dash = "-".repeat(maxLength);
            System.out.print(dash);
            System.out.println(pipe);
        }
    }

    private int findMaxLengthBookshelf() {
        int maxLength = 0;
        for (Book book : books) {
            if (book == null) break;
            String con = book.toString();
            maxLength = Math.max(maxLength, con.length());
        }
        return maxLength;
    }

    void viewCurrBooksCount() {
        System.out.print("В шкафу книг - " + currBooksCount);
    }

    void viewFreeShelfCount() {
        int freeShelfCount = getFreeShelfCount();
        System.out.println(", свободно полок - " + freeShelfCount + "\n");
    }

    private int getFreeShelfCount() {
        return MAX_TOTAL_BOOKS - currBooksCount;
    }
}
