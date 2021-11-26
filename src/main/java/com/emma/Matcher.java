package com.emma;

import java.util.Locale;

public class Matcher {

    public static boolean containsCaseInsensitive(String whole, String part) {

        return whole.toLowerCase(Locale.ROOT).contains(part.toLowerCase(Locale.ROOT));
    }
}
