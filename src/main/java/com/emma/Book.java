package com.emma;

import java.util.ArrayList;
import java.util.Objects;

public class Book {

    private String isbnNumber;
    private String title;
    private String author;
    private String genre;
    private String dateOfPublication;
    private boolean inStock;
    private ArrayList<Integer> rating;
    private ArrayList<String> comments;


    public Book(String isbnNumber, String title, String author, String genre, String yearOfPublication, boolean bookInStock, ArrayList<Integer> rating, ArrayList<String> comments) {
        this.isbnNumber = isbnNumber;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.dateOfPublication = yearOfPublication;
        this.inStock = bookInStock;
        this.rating = rating;
        this.comments = comments;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public ArrayList<Integer> getRating() {
        return rating;
    }

    public void setRating(ArrayList<Integer> rating) {
        this.rating = rating;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return inStock == book.inStock && Objects.equals(isbnNumber, book.isbnNumber) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(genre, book.genre) && Objects.equals(dateOfPublication, book.dateOfPublication) && Objects.equals(rating, book.rating) && Objects.equals(comments, book.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbnNumber, title, author, genre, dateOfPublication, inStock, rating, comments);
    }
}

