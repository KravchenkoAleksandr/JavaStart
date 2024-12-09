package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    static final int TOTAL_BOOKS = 10;
    private int booksCount;
    private final Book[] books;

    public Bookshelf() {
        books = new Book[TOTAL_BOOKS];
    }

    public int getBooksCount() {
        return booksCount;
    }

    public Book[] getBooks() {
        return books;
    }

    public boolean add(Book book) {
        if (booksCount >= TOTAL_BOOKS) return false;
        books[booksCount] = book;
        booksCount++;
        return true;
    }


    public boolean delete(String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals(title)) {
                int numberOfElements = booksCount - (i + 1);
                System.arraycopy(books, i + 1, books, i, numberOfElements);
                books[booksCount - 1] = null;
                booksCount--;
                return true;
            }
        }
        return false;
    }

    public Book find(String title) {
        for (Book book : books) {
            if (book == null) break;
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void clear() {
        Arrays.fill(books, 0, TOTAL_BOOKS, null);
        booksCount = 0;
    }
}