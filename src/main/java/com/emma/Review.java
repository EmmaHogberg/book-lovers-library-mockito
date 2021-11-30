package com.emma;

import java.util.ArrayList;

public class Review {


    public void addCommentToBook(Book book, String comment) {

        ArrayList<String> comments = new ArrayList<>();


        if (book.getComments() != null) {
            comments.addAll(book.getComments());
        }

        comments.add(comment);
        book.setComments(comments);

    }

    public void addRatingToBook(Book book, int rating) {
        ArrayList<Integer> ratings = new ArrayList<>();

        if (book.getRating() != null) {
            ratings.addAll(book.getRating());
        }

        ratings.add(rating);
        book.setRating(ratings);
    }
}
