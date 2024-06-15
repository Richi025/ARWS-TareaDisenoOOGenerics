package edu.escuelaing.arsw.ASE.app;
import java.util.Iterator;

/**
 * This class contains the implementation of the LinkedList and the methods to use with LinkedLists.
 */
public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    /**
     * Inner class to represent a node in the linked list
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Constructor to initialize an empty linked list
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Adds a new element to the end of the linked list.
     * @param data the element to add to the linked list.
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    /**
     * Returns an iterator over elements of type T.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Removes the element at the specified index in the linked list.
     *
     * @param index the index of the element to be removed.
     * @return the removed element.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        T removedData;
        if (index == 0) {
            removedData = head.data;
            head = head.next;
        } else {
            Node<T> previous = null;
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }
            removedData = current.data;
            previous.next = current.next;
        }
        size--;
        return removedData;
    }
}
