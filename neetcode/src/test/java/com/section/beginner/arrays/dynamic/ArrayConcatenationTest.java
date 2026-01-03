package com.section.beginner.arrays.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayConcatenationTest {

    @Test
    void testNormalCase() {
        int[] input = {1, 2, 3};
        int[] expected = {1, 2, 3, 1, 2, 3};
        assertArrayEquals(expected, ArrayConcatenation.getConcatenation(input));
    }

    @Test
    void testEmptyArray() {
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, ArrayConcatenation.getConcatenation(input));
    }

    @Test
    void testSingleElement() {
        int[] input = {42};
        int[] expected = {42, 42};
        assertArrayEquals(expected, ArrayConcatenation.getConcatenation(input));
    }

    @Test
    void testNegativeNumbers() {
        int[] input = {-1, -2};
        int[] expected = {-1, -2, -1, -2};
        assertArrayEquals(expected, ArrayConcatenation.getConcatenation(input));
    }
}