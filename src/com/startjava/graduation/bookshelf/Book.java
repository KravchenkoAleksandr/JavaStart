package com.startjava.graduation.bookshelf;

public class Book {

    private final String author;
    private final String title;
    private final int yearRelease;

    public Book(String author, String title, int yearProduction) {
        this.author = author;
        this.title = title;
        this.yearRelease = yearProduction;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return author + ", " +
                title + ", "
                + yearRelease;
    }
}
