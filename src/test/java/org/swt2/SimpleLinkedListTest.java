package org.swt2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SimpleLinkedListTest {

    SimpleLinkedList<Integer> emptyList;
    SimpleLinkedList<Integer> filledList;
    SimpleLinkedList<Integer> list;

    @BeforeEach
    void setup() {
        emptyList = new SimpleLinkedList<>();
        filledList = new SimpleLinkedList<>();
        for(int i = 1; i <= 10; i++) {
            filledList.add(i);
        }
        list = new SimpleLinkedList<>();
    }

    @Test
    void testEmptyList() {
        assertSame(emptyList.toString(), list.toString());
        list.add(1);
        assertNotSame(emptyList.toString(), list.toString());
    }

    @Test
    void testNullInput() {
        Exception exception = assertThrows(
                NullPointerException.class,
                () -> list.add(null)
        );
        assertTrue(exception.getMessage().contains("cannot be null"));
    }

    @Test
    void testAdd() {
        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertTrue(list.add(3));
        assertEquals(list.size(),3);
    }


    @Test
    void testSize() {
        assertEquals(list.size(), 0);

        for(int i = 0; i < 10; i++) {
            list.add(1);
        }

        assertEquals(list.size(), 10);
    }

    @Test
    void testHasNext() {
        assertFalse(list.iterator().hasNext());
        list.add(1);
        assertTrue(list.iterator().hasNext());
        Iterator<Integer> iterator = list.iterator();
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    void testNext() {
        assertThrows(
                NoSuchElementException.class,
                () -> list.iterator().next()
        );

        list.add(1);
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        assertEquals(iterator.next(), 1);
        assertEquals(iterator.next(), 2);
    }

    @Test
    void testRemove() {
        assertThrows(
                UnsupportedOperationException.class,
                () -> list.iterator().remove()
        );
        list.add(1);
        assertThrows(
                UnsupportedOperationException.class,
                () -> list.iterator().remove()
        );
    }
}
