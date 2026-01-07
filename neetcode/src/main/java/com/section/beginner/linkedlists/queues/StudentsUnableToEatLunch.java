package com.section.beginner.linkedlists.queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsUnableToEatLunch {
    public static void main(String[] args) {
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        System.out.println(studentsUnableToEatLunch(students, sandwiches));
    }

    public static int studentsUnableToEatLunch(int[] students, int[] sandwiches) {
        List<Integer> studentsList = Arrays.stream(students).boxed().collect(Collectors.toCollection(ArrayList::new));
        List<Integer> sandwichesList = Arrays.stream(sandwiches).boxed().collect(Collectors.toCollection(ArrayList::new));

        while (!studentsList.isEmpty() && !sandwichesList.isEmpty()) {
            List<Integer> studentsCopy = new ArrayList<>(studentsList);

            int student = studentsList.removeFirst();
            int sandwich = sandwichesList.getFirst();

            if (student == sandwich)
                sandwichesList.removeFirst();
            else
                studentsList.add(student);

            if (studentsList.equals(studentsCopy))
                break;

        }

        return studentsList.size();
    }
}
