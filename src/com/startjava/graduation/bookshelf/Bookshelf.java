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

    public void add(Book book) {
        books[booksCount++] = book;
        int len = book.toString().length();
        updateMaxLength(len);
    }

    public void delete(String title) {
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equals(title)) {
                int len = books[i].toString().length();
                booksCount--;
                int elementsNumber = booksCount - i;
                System.arraycopy(books, i + 1, books, i, elementsNumber);
                books[booksCount] = null;
                recalculateMaxLength(len);
                return;
            }
        }
        throw new NotFoundException("Введенная для удаления книга не найдена");
    }

    public Book find(String title) {
        for (Book book : books) {
            if (book == null) break;
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new NotFoundException("Книга не найдена");
    }

    public void clear() {
        Arrays.fill(books, 0, booksCount, null);
        booksCount = 0;
    }

    private void updateMaxLength(int len) {
        maxLength = Math.max(maxLength, len);
    }

    private void recalculateMaxLength(int len) {
        if (maxLength == len) {
            maxLength = 0;
            for (Book currBook : books) {
                if (currBook == null) break;
                int newLen = currBook.toString().length();
                updateMaxLength(newLen);
            }
        }
    }
}