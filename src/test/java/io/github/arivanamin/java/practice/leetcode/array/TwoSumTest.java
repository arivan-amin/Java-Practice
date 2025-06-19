package io.github.arivanamin.java.practice.leetcode.array;

import io.github.arivanamin.java.practice.BaseUnitTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class TwoSumTest implements BaseUnitTest {

    private TwoSum twoSum;

    @BeforeEach
    void setUp () {
        twoSum = new TwoSum();
    }

    @Test
    void twoSumShouldReturnTwoCorrectResult () {
        // given
        int[] numbers = { 2, 7, 11, 15 };

        // when
        int[] result = twoSum.twoSum(numbers, 9);

        // then
        assertThat(result).contains(0, 1);
    }

    @Test
    void twoSumShouldReturnCorrectIndex () {
        // given
        int[] numbers = { 3, 2, 4 };

        // when
        int[] result = twoSum.twoSum(numbers, 6);

        // then
        assertThat(result).contains(1, 2);
    }
}
