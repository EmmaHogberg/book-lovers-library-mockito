package com.emma;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {

    private Review review = new Review();
    private Book isbrytare = new Book("9789137501871", "Isbrytare", "Kristina Ohlsson", "Deckare", "2021-11-02", true, null, null);


    @Test
    void should_AddFirstCommentToBook_when_BookReviewed() {

        String comment = "En riktigt spännande bok som jag inte kunde lägga ifrån mig, rekommenderar den starkt!";
        ArrayList<String> actual = new ArrayList<>();
        actual.add(comment);

        review.addCommentToBook(isbrytare, comment);

        ArrayList<String> expected = new ArrayList<>(isbrytare.getComments());

        assertEquals(actual, expected);
    }

    @Test
    void should_AddAdditionalCommentToBook_when_BookReviewedTwoTimes() {

        String commentOne = "En riktigt spännande bok som jag inte kunde lägga ifrån mig, rekommenderar den starkt!";
        String commentTwo = "Kass, kan användas för att tända brasan med, men gav mig inte mycket mer än så";
        ArrayList<String> actual = new ArrayList<>();
        actual.add(commentOne);
        actual.add(commentTwo);

        review.addCommentToBook(isbrytare, commentOne);
        review.addCommentToBook(isbrytare, commentTwo);

        ArrayList<String> expected = new ArrayList<>(isbrytare.getComments());

        assertEquals(actual, expected);
    }

    @Test
    void should_AddFirstRatingToBook_when_BookReviewed() {

        int rating = 4;
        ArrayList<Integer> actual = new ArrayList<>();
        actual.add(rating);

        review.addRatingToBook(isbrytare, rating);

        ArrayList<Integer> expected = new ArrayList<>(isbrytare.getRating());

        assertEquals(actual, expected);
    }

    @Test
    void should_AddAdditionalRatingsToBook_when_BookReviewedManyTimes() {

        int ratingOne = 4;
        int ratingTwo = 3;
        int ratingThree = 5;
        int ratingFour = 4;

        ArrayList<Integer> actual = new ArrayList<>();
        actual.add(ratingOne);
        actual.add(ratingTwo);
        actual.add(ratingThree);
        actual.add(ratingFour);

        review.addRatingToBook(isbrytare, ratingOne);
        review.addRatingToBook(isbrytare, ratingTwo);
        review.addRatingToBook(isbrytare, ratingThree);
        review.addRatingToBook(isbrytare, ratingFour);

        ArrayList<Integer> expected = new ArrayList<>(isbrytare.getRating());

        assertEquals(actual, expected);
    }


}