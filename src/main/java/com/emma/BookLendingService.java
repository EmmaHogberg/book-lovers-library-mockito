package com.emma;

import java.util.HashSet;


public class BookLendingService {

    private final SearchBook searchBook = new SearchBook(new LibraryOfBooks());

    public HashSet<Book> getSearchResult(String input) {

        return searchBook.getBooksFromSearch(input);
    }

    public HashSet<Book> getSearchResultForBestBooks() {

        return searchBook.getTopRatedBooks();
    }



    public void printSearchResult(HashSet<Book> searchResult) {

        if (searchResult.isEmpty()) {
            System.out.println("No matching books");
        }

        for (Book book : searchResult) {
            System.out.println(book.getTitle());
            System.out.println(book.getAuthor());
            System.out.println(book.getGenre());
            System.out.println(book.getDateOfPublication());
            System.out.println(book.getIsbnNumber());
            if (book.isInStock()) {
                System.out.println("Book status: Available");
            } else
                System.out.println("Book status: Not available");

            System.out.println(" ");
        }
    }



    public void loanBook(Book book, boolean paid) {

        if (book.isInStock() && paid) {

            book.setInStock(false);

        }
    }

}
