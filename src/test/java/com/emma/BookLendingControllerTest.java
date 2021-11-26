package com.emma;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookLendingControllerTest {

    private LibraryOfBooks libraryOfBooks;
    private Book book;
    BookLendingController bookLendingController = new BookLendingController();



    @BeforeEach
    void setup() {
        book = mock(Book.class);
    }






    // Availability
    @Test
    public void should_ReturnTrue_when_BookIsAvailable() {
        when(bookLendingController.isBookAvailable(book)).thenReturn(true);
        assertTrue(bookLendingController.isBookAvailable(book));
    }

    @Test
    public void should_ReturnFalse_when_BookIsNotAvailable() {
        when(bookLendingController.isBookAvailable(book)).thenReturn(false);
        assertFalse(bookLendingController.isBookAvailable(book));
    }

    // Pay for book loan
    @Test
    void should_MakeBookLoan_when_Paid() {

    }


    // Loan a book
    @Test
    public void should_SetBookAsNotAvailable_when_OnLoan() {



    }



}