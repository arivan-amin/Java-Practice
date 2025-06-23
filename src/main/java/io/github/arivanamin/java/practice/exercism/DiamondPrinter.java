package io.github.arivanamin.java.practice.exercism;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Slf4j
public class DiamondPrinter {

    private final List<String> lines = new ArrayList<>();
    private int centerSpaces;
    private int sidesSpaces;

    List<String> printToList (char letter) {
        int lettersCount = letter - 'A' + 1;

        createDiamondTopHalf(lettersCount);
        resetCountersToRowBeforeMiddle();
        createDiamondBottomHalf(letter, lettersCount);
        return unmodifiableList(lines);
    }

    private void createDiamondTopHalf (int lettersCount) {
        centerSpaces = -1;
        sidesSpaces = lettersCount - 1;

        for (int i = 0; i < lettersCount; i++) {
            StringBuilder currentLine = new StringBuilder();
            char currentChar = (char) ('A' + i);

            addSideSpaces(currentLine, sidesSpaces);
            addCenterSpaces(centerSpaces, currentLine, currentChar);
            addSideSpaces(currentLine, sidesSpaces);

            lines.add(currentLine.toString());
            sidesSpaces--;
            centerSpaces += 2;
        }
    }

    private void resetCountersToRowBeforeMiddle () {
        sidesSpaces += 2;
        centerSpaces -= 4;
    }

    private void createDiamondBottomHalf (char letter, int lettersCount) {
        for (int i = 0; i < lettersCount - 1; i++) {
            StringBuilder currentLine = new StringBuilder();
            char currentChar = (char) (letter - (i + 1));

            addSideSpaces(currentLine, sidesSpaces);
            addCenterSpaces(centerSpaces, currentLine, currentChar);
            addSideSpaces(currentLine, sidesSpaces);

            lines.add(currentLine.toString());
            sidesSpaces++;
            centerSpaces -= 2;
        }
    }

    private void addSideSpaces (StringBuilder currentLine, int sidesCounter) {
        currentLine.append(" ".repeat(sidesCounter));
    }

    private void addCenterSpaces (int centerCounter, StringBuilder currentLine, char currentChar) {
        currentLine.append(currentChar);
        if (centerCounter > 0) {
            currentLine.append(" ".repeat(centerCounter));
            currentLine.append(currentChar);
        }
    }
}






