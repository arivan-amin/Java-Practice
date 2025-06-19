package io.github.arivanamin.java.practice.leetcode.string;

import io.github.arivanamin.java.practice.BaseUnitTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class LongestCommonPrefixTest implements BaseUnitTest {

    private LongestCommonPrefix commonPrefix;
    private List<String> words;

    @BeforeEach
    void setUp () {
        commonPrefix = new LongestCommonPrefix();
        words = new ArrayList<>();
    }

    @Test
    void findCommonPrefixShouldReturnEmptyStringWhenNoCommonPrefixExists () {
        // given
        words.add("alpha");
        words.add("bravo");
        words.add("delta");

        // when
        String result = commonPrefix.findCommonPrefix(words);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void findCommonPrefixShouldReturnCorrectPrefix () {
        // given
        words.add("flower");
        words.add("flow");
        words.add("flight");

        // when
        String result = commonPrefix.findCommonPrefix(words);

        // then
        assertThat(result).isEqualTo("fl");
    }
}
