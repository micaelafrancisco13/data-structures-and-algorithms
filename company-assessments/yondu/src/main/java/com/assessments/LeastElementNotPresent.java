package com.assessments;

import java.util.*;

public class LeastElementNotPresent {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 3};

        System.out.println("First missing positive integer is: " + solution(numbers));
    }

    private static int solution(int[] numbers) {
        int[] arr = Arrays.stream(numbers).sorted().toArray();

        Set<Integer> set = new HashSet<>();
        for (var num : arr)
            set.add(num);

        var min = arr[0];
        if (min > 1)
            return 1;

        min = 1;
        while (set.contains(min))
            ++min;
        return min;
    }
}
