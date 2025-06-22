package io.github.arivanamin.java.practice.exercism;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

import static java.lang.Character.isDigit;

@Slf4j
public class IsbnVerifier {

    public static final int ISBN_VALIDITY_MOD = 11;

    boolean isValid (String stringToVerify) {
        String isbnString = removeHyphens(stringToVerify);
        if (isLengthOrCheckDigitInvalid(isbnString)) {
            return false;
        }
        String isbnWithoutCheckDigit = isbnString.substring(0, 9);
        char checkDigit = isbnString.charAt(9);
        if (doesIsbnContainInvalidCharacters(isbnWithoutCheckDigit)) {
            return false;
        }

        int total = calculateSumOfEachDigit(isbnWithoutCheckDigit);

        total += getScoreOfCheckDigit(checkDigit);
        return calculateIfValidISBN(total);
    }

    private static String removeHyphens (String stringToVerify) {
        return stringToVerify.replaceAll("-", "");
    }

    private static boolean isLengthOrCheckDigitInvalid (String isbnString) {
        return isIsbnLengthInvalid(isbnString) || isCheckDigitInvalid(isbnString);
    }

    private static boolean doesIsbnContainInvalidCharacters (String isbnString) {
        return !isbnString.chars()
            .allMatch(Character::isDigit);
    }

    private static int calculateSumOfEachDigit (String isbnWithoutCheckDigit) {
        return IntStream.range(0, isbnWithoutCheckDigit.length())
            .map(i -> (10 - i) * parseCharacterToNumber(isbnWithoutCheckDigit.charAt(i)))
            .sum();
    }

    private static int getScoreOfCheckDigit (char checkDigit) {
        return checkDigit == 'X' ? 10 : parseCharacterToNumber(checkDigit);
    }

    private static boolean calculateIfValidISBN (int total) {
        return total % ISBN_VALIDITY_MOD == 0;
    }

    private static boolean isIsbnLengthInvalid (String isbnString) {
        return isbnString.length() != 10;
    }

    private static boolean isCheckDigitInvalid (String isbnString) {
        return !(isDigit(isbnString.charAt(9)) || isbnString.charAt(9) == 'X');
    }

    private static int parseCharacterToNumber (char checkDigit) {
        return Integer.parseInt(String.valueOf(checkDigit));
    }
}
