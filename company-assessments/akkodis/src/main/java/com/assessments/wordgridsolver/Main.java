package com.assessments.wordgridsolver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        char[][] board = {
                {'C', 'A', 'T'},
                {'R', 'R', 'E'},
                {'Z', 'O', 'N'}
        };

        Set<String> dictionary = new HashSet<>(Arrays.asList(
                "cat", "crater", "one", "tar", "tate", "car", "eat", "tan", "cater"
        ));

        Set<String> words = WordGridSolver.searchWords(board, dictionary);
        System.out.println("Words found in the grid:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}