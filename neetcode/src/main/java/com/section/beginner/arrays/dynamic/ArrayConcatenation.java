package com.section.beginner.arrays.dynamic;

import java.util.Arrays;

public class ArrayConcatenation {
    public static void main(String[] args) {
        var input = new int[] {1, 2, 3, 4, 5};
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Output: " + Arrays.toString(getConcatenation(input)));
    }

    public static int[] getConcatenation(int[] nums) {
        final int DOUBLED = 2;
        var numsLength = nums.length;

        int[] ans = Arrays.copyOf(nums, numsLength * DOUBLED); // Copy nums into first half, rest is zero
        System.arraycopy(nums, 0, ans, numsLength, numsLength); // Copy nums into second half

        return ans;
    }
}
