package com.emma;

import java.util.ArrayList;
import java.util.HashSet;

public class SearchBook {

    private final LibraryOfBooks libraryOfBooks;

    public SearchBook(LibraryOfBooks libraryOfBooks) {
        this.libraryOfBooks = libraryOfBooks;
    }


    // Search books by matching input search words to book in library
    public HashSet<Book> getBooksFromSearch(String input) {
        ArrayList<Book> books = libraryOfBooks.getBooksFromLibrary();

        HashSet<Book> searchResult = new HashSet<>();

        // Trim
        input = input.trim();

        // Check that input length is valid
        if (input.length() >= 2) {

            HashSet<String> searchWords = inputToSearchWords(input);

            for (Book book : books) {
                for (String searchWord : searchWords) {

                    if (Matcher.containsCaseInsensitive(book.getTitle(), searchWord) ||
                            Matcher.containsCaseInsensitive(book.getAuthor(), searchWord) ||
                            Matcher.containsCaseInsensitive(book.getGenre(), searchWord) ||
                            Matcher.containsCaseInsensitive(book.getDateOfPublication(), searchWord)) {
                        searchResult.add(book);
                    }
                }
            }
        }
        return searchResult;
    }

    // Search for books with the highest rating
    public HashSet<Book> getTopRatedBooks() {

        ArrayList<Book> books = libraryOfBooks.getBooksFromLibrary();
        HashSet<Book> searchResult = new HashSet<>();
        double ratingSummery = 0;

        for (Book book : books) {

            if (book.getRating() != null) {

                for (int i = 0; i < book.getRating().size(); i++) {

                    ratingSummery += book.getRating().get(i);
                }
                ratingSummery = ratingSummery / book.getRating().size();
                if (ratingSummery >= 4) {
                    searchResult.add(book);
                }
            }
        }
        return searchResult;
    }


    // Separate input to search words
    public static HashSet<String> inputToSearchWords(String input) {
        HashSet<String> searchWords = new HashSet<String>();

        String[] inputArray = input.trim().split(" ");

        for (String s : inputArray) {
            if (!s.equals("") && input.length() >= 2) {
                searchWords.add(s);
            }
        }
        return searchWords;
    }



}

