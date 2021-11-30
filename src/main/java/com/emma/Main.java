package com.emma;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        String input = "Kristina";
        Book book = null;
        String comment = "Bra bok";
        int rating = 3;

        BookLendingService bookLendingService = new BookLendingService();
        Review review = new Review();

        // Book search
        HashSet<Book> searchResult = bookLendingService.getSearchResult(input);
        bookLendingService.printSearchResult(searchResult);

        // Loan book och pay
        if (!searchResult.isEmpty()) {
            book = searchResult.iterator().next();
            bookLendingService.loanBook(book,true);
        }

        // Print receipt from lending
        searchResult = bookLendingService.getSearchResult(input);
        bookLendingService.printSearchResult(searchResult);

        // Leave a rating and comment on book
        if (book != null) {
            review.addCommentToBook(book, comment);
            review.addRatingToBook(book, rating);
        }

        // Search for top-rated books
        searchResult = bookLendingService.getSearchResultForBestBooks();





    }
}
