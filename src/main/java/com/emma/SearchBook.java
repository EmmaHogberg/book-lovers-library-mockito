package com.emma;

import java.util.ArrayList;
import java.util.HashSet;

public class SearchBook {

    private final LibraryOfBooks libraryOfBooks;

    public SearchBook(LibraryOfBooks libraryOfBooks) {
        this.libraryOfBooks = libraryOfBooks;
    }

    public HashSet<Book> getBooksFromSearch(String input) {
        ArrayList<Book> books = libraryOfBooks.getBooksFromLibrary();

        HashSet<Book> searchResult = new HashSet<>();

        // Trim
        input = input.trim();

        // Check that input length is valid
        if (input.length() > 2) {

            for (Book book : books) {

                if (Matcher.containsCaseInsensitive(book.getTitle(), input) ||
                        Matcher.containsCaseInsensitive(book.getAuthor(), input) ||
                        Matcher.containsCaseInsensitive(book.getGenre(), input) ||
                        Matcher.containsCaseInsensitive(book.getDateOfPublication(), input)) {
                    searchResult.add(book);
                }
            }
        }
        return searchResult;
    }
}