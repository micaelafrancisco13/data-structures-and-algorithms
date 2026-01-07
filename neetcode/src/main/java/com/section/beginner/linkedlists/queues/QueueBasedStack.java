package com.section.beginner.linkedlists.queues;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBasedStack {
    private final Deque<Integer> integerQueue;

    public QueueBasedStack() {
        integerQueue = new LinkedList<>();
    }

    public void push(int x) {
        integerQueue.add(x);
    }

    public int pop() {
        return integerQueue.removeLast();
    }

    public int top() {
        return integerQueue.getLast();
    }

    public boolean empty() {
        return integerQueue.isEmpty();
    }
}
