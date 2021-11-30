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
        searchBook = new SearchBook(libraryOfBooks);
        books = new ArrayList<Book>();
        books.add(julIKrinolin);
        books.add(depphjarnan);
        books.add(isbrytare);
        books.add(obscuritas);
        books.add(julVidHavet);
        books.add(elva);
    }

    // Input trim and validation
    @Test
    void should_TrimInputAndReturnCorrectBooks_when_ExtraSpaceInInputOnSearch() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(julIKrinolin);
        expected.add(julVidHavet);

        HashSet<Book> actual = searchBook.getBooksFromSearch("    Jul         ");

        assertEquals(expected, actual);
    }

    @Test
    void should_ReturnEmptyHashSet_when_InputLessThenTwoChar() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();

        HashSet<Book> actual = searchBook.getBooksFromSearch("j");

        assertEquals(expected, actual);
    }

    @Test
    void should_ReturnEmptyHashSet_when_EmptyInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();

        HashSet<Book> actual = searchBook.getBooksFromSearch("");

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnEmptyHashSet_when_WeirdNoMatchingInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();

        HashSet<Book> actual = searchBook.getBooksFromSearch("+ () kl");

        assertEquals(expected, actual);
    }


    // Search by title
    @Test
    void should_ReturnCorrectTwoBooks_when_MatchingInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(julIKrinolin);
        expected.add(julVidHavet);

        HashSet<Book> actual = searchBook.getBooksFromSearch("Jul");

        assertEquals(expected, actual);
    }

    @Test
    void should_ReturnCorrectBook_when_MatchingLowerCaseInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(julIKrinolin);
        expected.add(julVidHavet);

        HashSet<Book> actual = searchBook.getBooksFromSearch("jul");

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnEmptyHashSet_when_NoMatchingTitleInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        HashSet<Book> actual = searchBook.getBooksFromSearch("Hund");

        assertEquals(expected, actual);
    }


    // Search by author
    @Test
    public void should_ReturnCorrectBook_when_AuthorFirstNameInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(depphjarnan);

        HashSet<Book> actual = searchBook.getBooksFromSearch("Anders");

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnCorrectBook_when_AuthorLastNameInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(obscuritas);

        HashSet<Book> actual = searchBook.getBooksFromSearch("Lagercrantz");

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnCorrectBook_when_MatchingAuthorNameAndTitleInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(obscuritas);
        expected.add(elva);

        HashSet<Book> actual = searchBook.getBooksFromSearch("David Lagercrantz");

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnEmptyHashSet_when_NoMatchingNameInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();

        HashSet<Book> actual = searchBook.getBooksFromSearch("Emma Högberg");

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnBook_when_PartlyMatchingNameInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(obscuritas);

        HashSet<Book> actual = searchBook.getBooksFromSearch("Emma Lagercrantz");

        assertEquals(expected, actual);
    }


    // Search by genre
    @Test
    public void should_ReturnCorrectBook_when_MatchingGenreInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(julIKrinolin);

        HashSet<Book> actual = searchBook.getBooksFromSearch("Roman");

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnCorrectThreeBooks_when_MatchingGenreInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(isbrytare);
        expected.add(obscuritas);
        expected.add(elva);

        HashSet<Book> actual = searchBook.getBooksFromSearch("Deckare");

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnEmptyHashSet_when_NoMatchingGenreInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();

        HashSet<Book> actual = searchBook.getBooksFromSearch("Historia");

        assertEquals(expected, actual);
    }


    // Search by date
    @Test
    public void should_ReturnCorrectBook_when_FullMatchingDateInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(obscuritas);

        HashSet<Book> actual = searchBook.getBooksFromSearch("2021-11-01");

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnCorrectBooks_when_MatchingYearInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(julIKrinolin);
        expected.add(depphjarnan);
        expected.add(isbrytare);
        expected.add(obscuritas);
        expected.add(julVidHavet);
        expected.add(elva);

        HashSet<Book> actual = searchBook.getBooksFromSearch("2021");

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnCorrectBooks_when_MatchingMonthOrDayInput() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();
        expected.add(isbrytare);
        expected.add(obscuritas);
        expected.add(julVidHavet);

        HashSet<Book> actual = searchBook.getBooksFromSearch("11");

        assertEquals(expected, actual);
    }


    // Search for books with the highest rating
    @Test
    void should_ReturnBestBook_when_SearchForBookWithHighestRating() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        ArrayList<Integer> highRating = new ArrayList<>();
        highRating.add(5);
        highRating.add(4);
        highRating.add(5);
        obscuritas.setRating(highRating);
        System.out.println(obscuritas.getRating());

        ArrayList<Integer> lowRating = new ArrayList<>();
        lowRating.add(2);
        lowRating.add(3);
        lowRating.add(2);
        elva.setRating(lowRating);

        HashSet<Book> expected = new HashSet<>();
        expected.add(obscuritas);

        HashSet<Book> actual = searchBook.getTopRatedBooks();

        assertEquals(expected, actual);
    }

    @Test
    void should_ReturnEmptyHashSet_when_ThereIsNoRatedBook() {
        when(libraryOfBooks.getBooksFromLibrary()).thenReturn(books);

        HashSet<Book> expected = new HashSet<>();

        HashSet<Book> actual = searchBook.getTopRatedBooks();

        assertEquals(expected, actual);
    }
}