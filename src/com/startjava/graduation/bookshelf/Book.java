package com.startjava.graduation.bookshelf;

public class Book {

    private final String author;
    private final String title;
    private final int published;

    public Book(String author, String title, int published) {
        this.author = author;
        this.title = title;
        this.published = published;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return author + ", " +
                title + ", "
                + published;
    }
}
