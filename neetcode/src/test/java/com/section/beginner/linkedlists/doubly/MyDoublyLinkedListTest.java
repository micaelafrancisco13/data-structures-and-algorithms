package com.section.beginner.linkedlists.doubly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyDoublyLinkedListTest {
    private MyDoublyLinkedList list;

    @BeforeEach
    void setUp() {
        list = new MyDoublyLinkedList();
    }

    @Nested
    @DisplayName("Initialization and State")
    class InitializationTests {

        @Test
        @DisplayName("New list should be empty")
        void new_list_should_be_empty() {
            assertEquals(0, list.size(), "A new list should have a size of 0.");
            assertTrue(list.isEmpty(), "isEmpty() should return true for a new list.");
        }

        @Test
        @DisplayName("getHead on empty list should throw NoSuchElementException")
        void getHead_onEmptyList_shouldThrowException() {
            assertThrows(NoSuchElementException.class,
                    () -> list.getHead(),
                    "getHead() should throw NoSuchElementException on an empty list.");
        }

        @Test
        @DisplayName("getTail on empty list should throw NoSuchElementException")
        void getTail_onEmptyList_shouldThrowException() {
            assertThrows(NoSuchElementException.class,
                    () -> list.getTail(),
                    "getTail() should throw NoSuchElementException on an empty list.");
        }
    }

    @Nested
    @DisplayName("addAtHead Method")
    class AddAtHeadTests {

        @Test
        @DisplayName("Should add element to an empty list")
        void addAtHead_toEmptyList_shouldSetHeadAndTail() {
            list.addAtHead(10);
            assertEquals(1, list.size());
            assertFalse(list.isEmpty());
            assertEquals(10, list.getHead());
            assertEquals(10, list.getTail());
        }

        @Test
        @DisplayName("Should add element to the front of a non-empty list")
        void addAtHead_toNonEmptyList_shouldUpdateHead() {
            list.addAtHead(20); // List: [20]
            list.addAtHead(10); // List: [10, 20]

            assertEquals(2, list.size());
            assertEquals(10, list.getHead());
            assertEquals(20, list.getTail());
            assertEquals(20, list.get(1)); // Verify the old head is now at index 1
        }
    }

    @Nested
    @DisplayName("addAtTail Method")
    class AddAtTailTests {

        @Test
        @DisplayName("Should add element to an empty list")
        void addAtTail_toEmptyList_shouldSetHeadAndTail() {
            list.addAtTail(10);
            assertEquals(1, list.size());
            assertEquals(10, list.getHead());
            assertEquals(10, list.getTail());
        }

        @Test
        @DisplayName("Should add element to the end of a non-empty list")
        void addAtTail_toNonEmptyList_shouldUpdateTail() {
            list.addAtTail(10); // List: [10]
            list.addAtTail(20); // List: [10, 20]

            assertEquals(2, list.size());
            assertEquals(10, list.getHead());
            assertEquals(20, list.getTail());
        }
    }

    @Nested
    @DisplayName("get Method")
    class GetTests {

        @BeforeEach
        void populateList() {
            // Creates a list: [10, 20, 30] for testing
            list.addAtTail(10);
            list.addAtTail(20);
            list.addAtTail(30);
        }

        @Test
        @DisplayName("Should get elements by valid index")
        void get_withValidIndex_shouldReturnValue() {
            assertEquals(10, list.get(0), "Should get the head element at index 0.");
            assertEquals(20, list.get(1), "Should get the middle element at index 1.");
            assertEquals(30, list.get(2), "Should get the tail element at index 2.");
        }

        @Test
        @DisplayName("Should throw IndexOutOfBoundsException for negative index")
        void get_withNegativeIndex_shouldThrowException() {
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        }

        @Test
        @DisplayName("Should throw IndexOutOfBoundsException for index equal to size")
        void get_withIndexEqualToSize_shouldThrowException() {
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
        }

        @Test
        @DisplayName("Should throw IndexOutOfBoundsException for index greater than size")
        void get_withIndexGreaterThanSize_shouldThrowException() {
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(100));
        }
    }

    @Nested
    @DisplayName("addAtIndex Method")
    class AddAtIndexTests {

        @Test
        @DisplayName("Should add at head when index is 0")
        void addAtIndex_atZero_shouldBehaveLikeAddAtHead() {
            list.addAtTail(20);
            list.addAtIndex(0, 10); // List: [10, 20]
            assertEquals(2, list.size());
            assertEquals(10, list.getHead());
            assertEquals(10, list.get(0));
            assertEquals(20, list.get(1));
        }

        @Test
        @DisplayName("Should add at tail when index is equal to size")
        void addAtIndex_atSize_shouldBehaveLikeAddAtTail() {
            list.addAtTail(10);
            list.addAtIndex(1, 20); // List: [10, 20]
            assertEquals(2, list.size());
            assertEquals(20, list.getTail());
            assertEquals(10, list.get(0));
            assertEquals(20, list.get(1));
        }

        @Test
        @DisplayName("Should add in the middle of the list")
        void addAtIndex_inTheMiddle_shouldInsertCorrectly() {
            list.addAtTail(10);
            list.addAtTail(30);
            list.addAtIndex(1, 20); // List: [10, 20, 30]

            assertEquals(3, list.size());
            assertEquals(10, list.get(0));
            assertEquals(20, list.get(1));
            assertEquals(30, list.get(2));
        }

        @Test
        @DisplayName("Should throw IndexOutOfBoundsException for negative index")
        void addAtIndex_withNegativeIndex_shouldThrowException() {
            assertThrows(IndexOutOfBoundsException.class, () -> list.addAtIndex(-1, 5));
        }

        @Test
        @DisplayName("Should throw IndexOutOfBoundsException for index greater than size")
        void addAtIndex_withIndexGreaterThanSize_shouldThrowException() {
            list.addAtTail(10);
            assertThrows(IndexOutOfBoundsException.class, () -> list.addAtIndex(2, 5));
        }
    }

    @Nested
    @DisplayName("deleteAtIndex Method")
    class DeleteAtIndexTests {

        @BeforeEach
        void populateList() {
            // Creates a list: [10, 20, 30]
            list.addAtTail(10);
            list.addAtTail(20);
            list.addAtTail(30);
        }

        @Test
        @DisplayName("Should delete the only element")
        void deleteAtIndex_onSingleElementList_shouldBecomeEmpty() {
            var singleItemList = new MyDoublyLinkedList();
            singleItemList.addAtHead(100);
            singleItemList.deleteAtIndex(0);
            assertTrue(singleItemList.isEmpty());
            assertEquals(0, singleItemList.size());
        }

        @Test
        @DisplayName("Should delete the head element")
        void deleteAtIndex_atZero_shouldUpdateHead() {
            list.deleteAtIndex(0); // List becomes [20, 30]
            assertEquals(2, list.size());
            assertEquals(20, list.getHead());
            assertEquals(20, list.get(0));
            assertEquals(30, list.get(1));
        }

        @Test
        @DisplayName("Should delete the tail element")
        void deleteAtIndex_atEnd_shouldUpdateTail() {
            list.deleteAtIndex(2); // List becomes [10, 20]
            assertEquals(2, list.size());
            assertEquals(20, list.getTail());
            assertEquals(10, list.get(0));
            assertEquals(20, list.get(1));
        }

        @Test
        @DisplayName("Should delete a middle element")
        void deleteAtIndex_inTheMiddle_shouldLinkNeighbors() {
            // The initial list is [10, 20, 30]
            list.deleteAtIndex(1); // List becomes [10, 30]

            assertEquals(2, list.size());
            assertEquals(10, list.get(0));
            assertEquals(30, list.get(1));
        }

        @Test
        @DisplayName("Should throw IndexOutOfBoundsException for invalid index")
        void deleteAtIndex_withInvalidIndex_shouldThrowException() {
            assertThrows(IndexOutOfBoundsException.class, () -> list.deleteAtIndex(-1));
            assertThrows(IndexOutOfBoundsException.class, () -> list.deleteAtIndex(3));
        }
    }

    @Nested
    @DisplayName("Complex Scenarios")
    class ComplexScenarios {
        @Test
        @DisplayName("Should maintain correct state after multiple mixed operations")
        void list_shouldBehaveCorrectly_afterMixedOperations() {
            assertTrue(list.isEmpty());

            list.addAtHead(10); // [10]
            list.addAtTail(30); // [10, 30]
            list.addAtIndex(1, 20); // [10, 20, 30]
            list.addAtHead(5); // [5, 10, 20, 30]
            list.addAtTail(40); // [5, 10, 20, 30, 40]

            assertEquals(5, list.size());
            assertEquals(5, list.get(0));
            assertEquals(20, list.get(2));
            assertEquals(40, list.get(4));

            list.deleteAtIndex(0); // [10, 20, 30, 40]
            assertEquals(10, list.getHead());

            list.deleteAtIndex(3); // [10, 20, 30]
            assertEquals(30, list.getTail());

            list.deleteAtIndex(1); // [10, 30]
            assertEquals(2, list.size());
            assertEquals(10, list.get(0));
            assertEquals(30, list.get(1));

            list.deleteAtIndex(1); // [10]
            list.deleteAtIndex(0); // []

            assertTrue(list.isEmpty());
        }
    }
}
