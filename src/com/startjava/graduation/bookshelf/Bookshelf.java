package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    static final int TOTAL_BOOKS = 10;
    private int booksCount;
    private final Book[] books;
    private int maxLength;

    public Bookshelf() {
        books = new Book[TOTAL_BOOKS];
    }

    public int getBooksCount() {
        return booksCount;
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, booksCount);
    }

    public int getMaxLength() {
        return maxLength;
    }

    public boolean add(Book book) {
        if (booksCount >= TOTAL_BOOKS) return false;
        books[booksCount++] = book;
        updateMaxLength(book);
        return true;
    }

    private void updateMaxLength(Book book) {
        int len = book.toString().length();
        if (maxLength < len) {
            maxLength = len;
        }
    }

    public boolean delete(String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals(title)) {
                int len = books[i].toString().length();
                booksCount--;
                int elementsNumber = booksCount - i;
                System.arraycopy(books, i + 1, books, i, elementsNumber);
                books[booksCount] = null;
                updateMaxLength(len);
                return true;
            }
        }
        return false;
    }

    private void updateMaxLength(int len) {
        if (maxLength == len) {
            maxLength = 0;
            for (Book currBook : books) {
                if (currBook == null) break;
                updateMaxLength(currBook);
            }
        }
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
        Arrays.fill(books, 0, booksCount, null);
        booksCount = 0;
    }
}