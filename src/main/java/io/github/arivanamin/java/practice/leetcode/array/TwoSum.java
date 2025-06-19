package io.github.arivanamin.java.practice.leetcode.array;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TwoSum {

    public int[] twoSum (int[] numbers, int target) {
        Map<Integer, Integer> passedElements = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int remaining = target - numbers[i];

            if (passedElements.containsKey(remaining)) {
                return new int[] { passedElements.get(remaining), i };
            }

            passedElements.put(numbers[i], i);
        }
        return new int[] { };
    }
}
