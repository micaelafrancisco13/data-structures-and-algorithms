package com.section.beginner.linkedlists;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
    private final List<String> history;
    private int currentIndex;
    private int lastIndex;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        currentIndex = 0;
        lastIndex = 0;
    }

    public void visit(String url) {
        if (currentIndex < lastIndex)
            history.subList(currentIndex + 1, lastIndex + 1).clear();

        history.add(url);
        currentIndex++;
        lastIndex = currentIndex;
    }

    public String back(int steps) {
        currentIndex = Math.max(0, currentIndex - steps);
        return history.get(currentIndex);
    }

    public String forward(int steps) {
        currentIndex = Math.min(lastIndex, currentIndex + steps);
        return history.get(currentIndex);
    }
}
