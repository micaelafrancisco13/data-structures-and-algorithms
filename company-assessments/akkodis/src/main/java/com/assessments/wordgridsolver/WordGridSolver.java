package com.assessments.wordgridsolver;

import java.util.*;

public class WordGridSolver {

    private static final int[] ROW_OFFSETS = {-1, 0, 1, 0};
    private static final int[] COL_OFFSETS = {0, 1, 0, -1};

    public static Set<String> searchWords(char[][] board, Set<String> dictionary) {
        if (board == null || board.length == 0 || board[0].length == 0 || dictionary == null) {
            return Collections.emptySet();
        }

        int height = board.length;
        int width = board[0].length;
        Set<String> matchedWords = new HashSet<>();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                boolean[][] visited = new boolean[height][width];
                explorePath(board, row, col, "", visited, dictionary, matchedWords);
            }
        }

        return matchedWords;
    }

    private static void explorePath(
            char[][] board,
            int row,
            int col,
            String path,
            boolean[][] visited,
            Set<String> dictionary,
            Set<String> matchedWords
    ) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return;
        }

        path += Character.toLowerCase(board[row][col]);

        if (dictionary.contains(path)) {
            matchedWords.add(path);
        }

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + ROW_OFFSETS[i];
            int nextCol = col + COL_OFFSETS[i];
            explorePath(board, nextRow, nextCol, path, visited, dictionary, matchedWords);
        }

        visited[row][col] = false;
    }
}