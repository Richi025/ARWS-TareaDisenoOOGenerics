package edu.escuelaing.arsw.ASE.app;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;

/**
 * This class tests the functionality of the LinkedList implementation.
 */
public class LinkedListTest {

    @Test
    public void testAddAndGetSize() {
        LinkedList<Integer> list = new LinkedList<>();
        assertEquals(0, list.getSize(), "Initial size should be 0");

        list.add(1);
        assertEquals(1, list.getSize(), "Size should be 1 after adding one element");

        list.add(2);
        assertEquals(2, list.getSize(), "Size should be 2 after adding two elements");
    }

    @Test
    public void testIterator() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> iterator = list.iterator();
        assertTrue(((Iterator<?>) iterator).hasNext(), "Iterator should have next element");
        assertEquals("A", iterator.next(), "First element should be 'A'");
        assertEquals("B", iterator.next(), "Second element should be 'B'");
        assertEquals("C", iterator.next(), "Third element should be 'C'");
        assertFalse(iterator.hasNext(), "Iterator should not have next element");
    }

    @Test
    public void testRemove() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        try {
            assertEquals(2, list.remove(1), "Removed element should be 2");
            assertEquals(2, list.getSize(), "Size should be 2 after removal");

            assertEquals(1, list.remove(0), "Removed element should be 1");
            assertEquals(1, list.getSize(), "Size should be 1 after removal");

            assertEquals(3, list.remove(0), "Removed element should be 3");
            assertEquals(0, list.getSize(), "Size should be 0 after removal");
        } catch (IndexOutOfBoundsException e) {
            fail("IndexOutOfBoundsException should not have been thrown");
        }
    }

    @Test
    public void testRemoveIndexOutOfBoundsException() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);

        try {
            list.remove(2);
            fail("IndexOutOfBoundsException expected for index out of range");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of range", e.getMessage());
        }

        try {
            list.remove(-1);
            fail("IndexOutOfBoundsException expected for negative index");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of range", e.getMessage());
        }
    }

    @Test
    public void testRemoveFromEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();

        try {
            list.remove(0);
            fail("IndexOutOfBoundsException expected when removing from empty list");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of range", e.getMessage());
        }
    }
}
