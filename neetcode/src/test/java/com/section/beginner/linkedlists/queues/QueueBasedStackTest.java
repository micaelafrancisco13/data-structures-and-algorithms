package com.section.beginner.linkedlists.queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueBasedStackTest {

    private QueueBasedStack stack;

    @BeforeEach
    void setUp() {
        stack = new QueueBasedStack();
    }

    // ----------------------------------------
    // Initial State & Empty Stack Tests
    // ----------------------------------------

    @Test
    @DisplayName("A new stack should be empty")
    void newStack_shouldBeEmpty() {
        assertTrue(stack.empty(), "A newly initialized stack should report empty() as true.");
    }

    @Test
    @DisplayName("pop() on an empty stack should throw NoSuchElementException")
    void pop_onEmptyStack_shouldThrowException() {
        assertThrows(NoSuchElementException.class, () -> {
            stack.pop();
        }, "pop() must throw NoSuchElementException when the stack is empty.");
    }

    @Test
    @DisplayName("top() on an empty stack should throw NoSuchElementException")
    void top_onEmptyStack_shouldThrowException() {
        // Assert that calling top() on an empty stack throws the expected exception
        assertThrows(NoSuchElementException.class, () -> {
            stack.top();
        }, "top() must throw NoSuchElementException when the stack is empty.");
    }

    // ----------------------------------------
    // Core Operation Tests
    // ----------------------------------------

    @Test
    @DisplayName("After one push, the stack should not be empty")
    void push_makesStackNotEmpty() {
        stack.push(42);
        assertFalse(stack.empty(), "Stack should not be empty after a push operation.");
    }

    @Test
    @DisplayName("push() followed by top() should return the pushed element")
    void push_thenTop_shouldReturnElement() {
        int expectedValue = 100;
        stack.push(expectedValue);
        assertEquals(expectedValue, stack.top(), "top() should return the last element pushed.");
    }

    @Test
    @DisplayName("push() followed by pop() should return the pushed element and make the stack empty")
    void push_thenPop_shouldReturnElementAndEmptyStack() {
        int expectedValue = -5;
        stack.push(expectedValue);
        int poppedValue = stack.pop();

        assertEquals(expectedValue, poppedValue, "pop() should return the last element pushed.");
        assertTrue(stack.empty(), "Stack should be empty after pushing and then popping one element.");
    }

    @Test
    @DisplayName("top() should return the top element without removing it")
    void top_shouldNotRemoveElement() {
        stack.push(99);
        stack.push(101);

        assertEquals(101, stack.top(), "First call to top() should return the correct element.");
        assertEquals(101, stack.top(), "Second call to top() should return the same element, as it shouldn't be removed.");

        assertEquals(101, stack.pop(), "pop() should return the element that top() was inspecting.");
    }

    // ----------------------------------------
    // LIFO (Last-In, First-Out) Behavior Test
    // ----------------------------------------

    @Test
    @DisplayName("Multiple pushes and pops should follow LIFO order")
    void multipleOperations_shouldFollowLIFO() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.top(), "top() should be the last element pushed (30).");

        assertEquals(30, stack.pop(), "First pop should be the last element pushed (30).");
        assertEquals(20, stack.pop(), "Second pop should be the second element pushed (20).");

        stack.push(40);

        assertEquals(40, stack.pop(), "Third pop should be the newest element (40).");
        assertEquals(10, stack.pop(), "Fourth pop should be the first element pushed (10).");

        assertTrue(stack.empty(), "Stack should be empty after all elements are popped.");
    }
}