package com.example.olikbookstore.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ISBNValidator {
    public static boolean isValidISBN(String isbn) {
        // Regular expression pattern for ISBN-10 or ISBN-13
        String pattern = "(\\d{3}-)?\\d{1,5}-\\d{1,7}-\\d{1,7}-\\d|\\d{1,5}-\\d{1,7}-\\d{1,7}-\\d{1,7}-\\d";

        // Create a Pattern object
        Pattern regex = Pattern.compile(pattern);

        // Create a Matcher object
        Matcher matcher = regex.matcher(isbn);

        // Check if the provided ISBN matches the pattern
        return matcher.matches();
    }
}