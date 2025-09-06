package com.section.beginner.binarysearch;

public class TwoDimensionalMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];

        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;

        matrix[1][0] = 4;
        matrix[1][1] = 6;
        matrix[1][2] = 7;

        matrix[2][0] = 8;
        matrix[2][1] = 9;
        matrix[2][2] = 10;

        System.out.println("Is element present in the matrix? " + solution(matrix, 9));
    }

    private static boolean solution(int[][] matrix, int target) {
        var height = matrix.length;
        var width = matrix[0].length;

        var targetRow = -1;
        for (var row = 0; row < height; ++row) {
            var firstColumnElement = matrix[row][0];
            var lastRowElement = matrix[row][width - 1];

            if (target >= firstColumnElement && target <= lastRowElement) {
                targetRow = row;
                break;
            }
        }

        var isPresent = false;
        if (targetRow >= 0) {
            var targetArray = matrix[targetRow];
            var left = 0;
            var right = width - 1;

            while (left <= right) {
                var mid = (left + right) / 2;
                var element = targetArray[mid];

                if (element < target)
                    left = mid + 1;
                else if (element > target)
                    right = mid - 1;
                else {
                    isPresent = true;
                    break;
                }
            }
        }

        return isPresent;
    }
}
