package io.github.arivanamin.java.practice.exercism;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Matrix {

    private final String matrixString;

    Matrix (String matrixAsString) {
        matrixString = matrixAsString;
    }

    int[] getRow (int rowNumber) {
        return Arrays.stream(matrixString.split(System.lineSeparator()))
            .skip(rowNumber - 1)
            .map(row -> row.split(" "))
            .flatMap(Arrays::stream)
            .map(Integer::parseInt)
            .mapToInt(Integer::intValue)
            .toArray();
    }

    int[] getColumn (int columnNumber) {
        String[] rows = matrixString.split(System.lineSeparator());
        return Arrays.stream(rows)
            .map(row -> row.split(" "))
            .map(strings -> strings[columnNumber - 1])
            .map(Integer::parseInt)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
