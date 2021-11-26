package com.emma;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatcherTest {

    @Test
    public void shouldReturnTrueWhenBothAreEqual() {
        assertTrue(Matcher.containsCaseInsensitive("Jul", "Jul"));
    }

    @Test
    public void shouldReturnFalseWhenNotContains() {
        assertFalse(Matcher.containsCaseInsensitive("Jul", "TypG"));
        assertFalse(Matcher.containsCaseInsensitive("Jul", "Jul i Krinolin"));
    }

    @Test
    public void shouldReturnTrueWhenContains() {
        assertTrue(Matcher.containsCaseInsensitive("Jul i Krinolin", "Jul"));
        assertTrue(Matcher.containsCaseInsensitive("Jul i Krinolin", "Krinolin"));
        assertTrue(Matcher.containsCaseInsensitive("Jul i Krinolin", ""));
        assertTrue(Matcher.containsCaseInsensitive("", ""));

    }

    @Test
    public void shouldReturnTrueWhenCaseDiffers() {
        assertTrue(Matcher.containsCaseInsensitive("Jul", "jul"));
        assertTrue(Matcher.containsCaseInsensitive("jul", "JUL"));
    }

    @Test
    public void shouldReturnTrueWhenPartOfDateIsEqual() {
        assertTrue(Matcher.containsCaseInsensitive("2021-11-19", "2021"));
    }

    @Test
    public void shouldReturnTrueWhenIsbnM() {
        assertTrue(Matcher.containsCaseInsensitive("jul", "jul"));
    }

}