package com.emma;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


class BookLendingServiceTest {

    private BookLendingService bookLendingService = new BookLendingService();
    private Book isbrytare = new Book("9789137501871", "Isbrytare", "Kristina Ohlsson", "Deckare", "2021-11-02", true, null, null);


    // Check original availability
    @Test
    void should_ReturnTrueInStock_when_BookInStock() {
        assertTrue(isbrytare.isInStock());
    }


    // Check changed availability when on loan
    @Test
    void should_LoanBook_and_SetAsNotAvailable_when_PaidAndInStock() {

        boolean expected = false;

        bookLendingService.loanBook(isbrytare, true);

        boolean actual = isbrytare.isInStock();

    }

}