package com.emma;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SearchBookTest {

    private LibraryOfBooks libraryOfBooks;
    private SearchBook searchBook;

    private static Book julIKrinolin = new Book("9789188803535", "Jul i krinolin", "Amanda Hellberg", "Roman", "2021-10-14", true, null, null);
    private static Book julVidHavet = new Book("9789113116594", "Jul på det lilla hotellet vid havet", "Jenny Colgan", "Skönlitteratur", "2021-10-11", true, null, null);
    private static Book depphjarnan = new Book("9789178871148", "Depphjärnan", "Anders Hansen", "Psykologi", "2021-10-28", true, null, null);
    private static Book isbrytare = new Book("9789137501871", "Isbrytare", "Kristina Ohlsson", "Deckare", "2021-11-02", true, null, null);
    private static Book obscuritas = new Book("9789113102603", "Obscuritas", "David Lagercrantz", "Deckare", "2021-11-01", true, null, null);
    private static Book elva = new Book("9789189298408", "Elva änkors man David", "Denise Rudberg", "Deckare", "2021-10-21", true, null, null);
    private ArrayList<Book> books;


    @BeforeEach
    void setup() {
        libraryOfBooks = mock(LibraryOfBooks.class);
       // searchBook = mock(SearchBook.class);
        searchBook = new SearchBook(libraryOfBooks);
        books = new ArrayList<Book>();
        books.add(julIKrinolin);
        books.add(depphjarnan);
        books.add(isbrytare);
        books.add(obscuritas);
        books.add(julVidHavet);
        books.add(elva);
    }



    // Search by title
    @Test
    void should_ReturnCorrectTwoBooks_When_MatchingInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(julIKrinolin);
        expected.add(julVidHavet);

        HashSet<Book> actual = searchBook.getBooksFromSearch("Jul");

        assertEquals(expected, actual);

    }

    @Test
    void should_ReturnCorrectBook_When_MatchingLowerCaseInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(julIKrinolin);
        expected.add(julVidHavet);

        HashSet<Book> actual = searchBook.getBooksFromSearch("jul");

        assertEquals(expected, actual);

    }


    @Test
    public void should_ReturnEmptyArray_When_NoMatchingTitleInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        HashSet<Book> actual = searchBook.getBooksFromSearch("Hund");

        assertEquals(expected, actual);
    }



    // Search by author
    @Test
    public void should_ReturnCorrectBook_When_AuthorFirstNameInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(depphjarnan);

        HashSet<Book> actual = searchBook.getBooksFromSearch("Anders");

        assertEquals(expected, actual);
    }


    @Test
    public void should_ReturnCorrectBook_When_AuthorLastNameInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(obscuritas);

        HashSet<Book> actual = searchBook.getBooksFromSearch("Lagercrantz");

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnCorrectBook_When_AuthorFullNameInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(obscuritas);

        HashSet<Book> actual = searchBook.getBooksFromSearch("David Lagercrantz");

        assertEquals(expected, actual);
    }




    @Test
    public void should_ReturnEmptyArray_When_NoMatchingNameInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();

        HashSet<Book> actual = searchBook.getBooksFromSearch("Emma Högberg");

        assertEquals(expected, actual);
    }



    @Test
    public void should_ReturnEmptyArray_When_WeirdAuthorInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();

        HashSet<Book> actual = searchBook.getBooksFromSearch("+ () kl");

        assertEquals(expected, actual);

    }


//    // Search by genre
//    @Test
//    public void should_ReturnCorrectBook_When_MatchingGenreInput() {
//
//        ArrayList<Book> expected = new ArrayList<>();
//        expected.add(julIKrinolin);
//
//        ArrayList<Book> actual = SearchBook.getBookByGenre(getBooks(),"Roman");
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void should_ReturnCorrectBooks_When_MatchingGenreInput() {
//
//        ArrayList<Book> expected = new ArrayList<>();
//        expected.add(isbrytare);
//        expected.add(obscuritas);
//        expected.add(elva);
//
//        ArrayList<Book> actual = SearchBook.getBookByGenre(getBooks(),"Deckare");
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void should_ReturnEmptyArray_When_NoMatchingGenreInput() {
//
//        ArrayList<Book> expected = new ArrayList<>();
//
//        ArrayList<Book> actual = SearchBook.getBookByGenre(getBooks(),"Historia");
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void should_ReturnEmptyArray_When_WeirdGenreInput() {
//
//        ArrayList<Book> expected = new ArrayList<>();
//
//        ArrayList<Book> actual = SearchBook.getBookByGenre(getBooks(),"+ () kl");
//
//        assertEquals(expected, actual);
//    }
//
//
//    // Search by date
//    @Test
//    public void should_ReturnCorrectBook_When_FullMatchingDateInput() {
//
//        ArrayList<Book> expected = new ArrayList<>();
//        expected.add(obscuritas);
//
//        ArrayList<Book> actual = SearchBook.getBookByPublicationDate(getBooks(),"2021-11-01");
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void should_ReturnCorrectBooks_When_MatchingYearInput() {
//
//        ArrayList<Book> expected = new ArrayList<>();
//        expected.add(julIKrinolin);
//        expected.add(depphjarnan);
//        expected.add(isbrytare);
//        expected.add(obscuritas);
//        expected.add(julVidHavet);
//        expected.add(elva);
//
//        ArrayList<Book> actual = SearchBook.getBookByPublicationDate(getBooks(),"2021");
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void should_ReturnCorrectBooks_When_MatchingMonthOrDayInput() {
//
//        ArrayList<Book> expected = new ArrayList<>();
//        expected.add(isbrytare);
//        expected.add(obscuritas);
//        expected.add(julVidHavet);
//
//        ArrayList<Book> actual = SearchBook.getBookByPublicationDate(getBooks(),"11");
//
//        assertEquals(expected, actual);
//    }
//
//






}