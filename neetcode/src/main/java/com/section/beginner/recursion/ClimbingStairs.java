package com.section.beginner.recursion;

public class ClimbingStairs {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; ++i) {
            System.out.println("Climbing stairs: " + solution(i));
        }
    }

    private static int solution(int i) {
        if (i == 0 || i == 1)
            return 1;

        return solution(i - 1) + solution(i - 2);
    }
}
