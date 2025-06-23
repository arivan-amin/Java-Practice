package io.github.arivanamin.java.practice.exercism;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.IntStream;

@Slf4j
public class SumOfMultiples {

    private final int level;
    private final List<Integer> items;

    SumOfMultiples (int number, int[] set) {
        level = number;
        items = Arrays.stream(set)
            .boxed()
            .toList();
    }

    int getSum () {
        return items.stream()
            .map(this::calculateDivisors)
            .flatMap(Collection::stream)
            .distinct()
            .mapToInt(Integer::intValue)
            .sum();
    }

    private List<Integer> calculateDivisors (Integer currentNumber) {
        return IntStream.range(1, level)
            .map(operand -> currentNumber * operand)
            .filter(value -> value < level)
            .boxed()
            .toList();
    }
}
