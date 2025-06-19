package io.github.arivanamin.java.practice.leetcode.string;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class LongestCommonPrefix {

    public String findCommonPrefix (List<String> words) {

        return IntStream.range(0, getMinLength(words))
            .mapToObj(i -> extractCharactersAtIndex(words, i))
            .filter(LongestCommonPrefix::didAllCharactersMatch)
            .map(List::getFirst)
            .collect(Collectors.joining());
    }

    private static int getMinLength (List<String> words) {
        return words.stream()
            .map(String::length)
            .mapToInt(Integer::intValue)
            .min()
            .orElseThrow();
    }

    private static List<String> extractCharactersAtIndex (List<String> words, int index) {
        List<String> chars = new ArrayList<>();
        for (String word : words) {
            chars.add(String.valueOf(word.charAt(index)));
        }
        return chars.stream()
            .distinct()
            .toList();
    }

    private static boolean didAllCharactersMatch (List<String> chars) {
        return chars.size() == 1;
    }
}
