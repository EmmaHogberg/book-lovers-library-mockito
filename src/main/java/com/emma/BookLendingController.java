package com.emma;

import java.util.HashSet;


public class BookLendingController {

    private String input = "Jul";


    public BookLendingController() {
        SearchBook searchBook = new SearchBook(new LibraryOfBooks());

        // Search book
        HashSet<Book> searchResult = searchBook.getBooksFromSearch(input);
        printSearchResult(searchResult);

        // Loan book



    }

    public void printSearchResult(HashSet<Book> searchResult) {

        for (Book book : searchResult) {
            System.out.println(book.getTitle());
            System.out.println(book.getAuthor());
            System.out.println(book.getGenre());
            System.out.println(book.getDateOfPublication());
            System.out.println(book.getIsbnNumber());
            if (book.isBookInStock()) {
                System.out.println("Book status: Available");
            } else
                System.out.println("Book status: Not available");

            System.out.println(" ");
        }
    }



    public void loanBook(Book book) {

        if (isBookAvailable(book)) {

            int payment = 50;
            boolean bookPaid = payForBook(payment);



        }



    }


    public boolean isBookAvailable(Book book) {
        return book.isBookInStock();
    }

    public boolean payForBook(int payment) {
        boolean bookPaid = false;

        if (payment == 50) {
            bookPaid = true;
        }
        return bookPaid;
    }


}
