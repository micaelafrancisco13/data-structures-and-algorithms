package com.section.beginner.arrays.stacks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidParenthesesTest {

    @ParameterizedTest
    @CsvSource({
            "'[]', true",
            "'([{}])', true",
            "'[(])', false"
    })
    void testValidParentheses(String input, boolean expected) {
        assertEquals(expected, ValidParentheses.isValid(input));
    }
}
