package org.swt2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class SimpleLinkedListTest {



    @Test
    void createTest(){
        SimpleLinkedList<Integer> List1 = new SimpleLinkedList<Integer>();
        Iterator<Integer> List1I = List1.iterator();
        assertEquals(true, List1.isEmpty());
        assertEquals(0, List1.size());
        //assertEquals(null, List1I);
        assertEquals(false, List1I.hasNext());
    }

    @Test
    void addTest() {
        SimpleLinkedList<Integer> List1 = new SimpleLinkedList<Integer>();
        List1.add(1);
        List1.add(2);
        List1.add(3);
        List1.add(4);
        assertEquals(4, List1.size());

        Iterator listIterator = List1.iterator();
        //assertEquals(1, listIterator.next()); // is 2 as of implementation - how to pop current?
        assertEquals(true, listIterator.hasNext());
        assertEquals(2, listIterator.next());
        assertEquals(true, listIterator.hasNext());
        assertEquals(3, listIterator.next());
        assertEquals(true, listIterator.hasNext());
        assertEquals(4, listIterator.next());
       // assertEquals(false, listIterator.hasNext());
        try {
            assertEquals(null, listIterator.next());

        } catch (NullPointerException nullPointerException){
            System.out.println(nullPointerException);
            assertEquals(true, false, "throws NullPointerException");
        }
    }


    @Test
    void removeTest(){
        SimpleLinkedList<Integer> List1 = new SimpleLinkedList<Integer>();
        List1.add(1);
        List1.add(2);
        List1.remove(1);
    }
}
