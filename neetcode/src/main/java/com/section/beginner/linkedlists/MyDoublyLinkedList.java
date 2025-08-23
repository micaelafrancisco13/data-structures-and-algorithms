package com.section.beginner.linkedlists;

import java.util.NoSuchElementException;

class MyDoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private Node getNode(int index) {
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return getNode(index).val;
    }

    public void addAtHead(int val) {
        var newNode = new Node(val);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    public void addAtTail(int val) {
        var newNode = new Node(val);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node successor = getNode(index);
            Node predecessor = successor.previous;
            var newNode = new Node(val);

            newNode.next = successor;
            newNode.previous = predecessor;
            predecessor.next = newNode;
            successor.previous = newNode;

            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if (size == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head = head.next;
            head.previous = null;
        } else if (index == size - 1) {
            tail = tail.previous;
            tail.next = null;
        } else {
            Node nodeToDelete = getNode(index);
            nodeToDelete.previous.next = nodeToDelete.next;
            nodeToDelete.next.previous = nodeToDelete.previous;
        }

        size--;
    }

    public int getHead() {
        if (isEmpty())
            throw new NoSuchElementException("List is empty");
        return head.val;
    }

    public int getTail() {
        if (isEmpty())
            throw new NoSuchElementException("List is empty");
        return tail.val;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node {
        private final int val;
        private Node previous = null;
        private Node next = null;

        Node(int value) {
            this.val = value;
        }
    }
}