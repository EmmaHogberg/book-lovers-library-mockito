package com.emma;

import java.util.ArrayList;

public class LibraryOfBooks {

    public ArrayList<Book> getBooksFromLibrary() {

        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("9789188803535", "Jul i krinolin", "Amanda Hellberg", "Roman", "2021-10-14", true, null, null);
        books.add(book);
        book = new Book("9789178871148", "Depphjärnan", "Anders Hansen", "Psykologi", "2021-10-28", false,  null, null);
        books.add(book);
        book = new Book("9789137501871", "Isbrytare", "Kristina Ohlsson", "Deckare", "2021-11-02", true,  null, null);
        books.add(book);
        book = new Book("9789113102603", "Obscuritas", "David Lagercrantz", "Deckare", "2021-11-01", true,  null, null);
        books.add(book);
        book = new Book("9789113116594", "Jul på det lilla hotellet vid havet", "Jenny Colgan", "Skönlitteratur", "2021-10-11", true,  null, null);
        books.add(book);
        book = new Book("9789189298408", "Elva änkors man David", "Denise Rudberg", "Deckare", "2021-10-21", true,  null, null);
        books.add(book);

     return books;
    }




}
