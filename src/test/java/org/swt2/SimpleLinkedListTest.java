package org.swt2;

import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SimpleLinkedListTest {
    
        @Test
        public void testAdd() {
            SimpleLinkedList<String> list = new SimpleLinkedList<String>();
            list.add("hello");
            list.add("world");
            assertEquals(2, list.size());
        }
    
        @Test
        public void testIterator() {
            SimpleLinkedList<String> list = new SimpleLinkedList<String>();
            list.add("hello");
            list.add("world");
            Iterator<String> iter = list.iterator();
            assertEquals(true, iter.hasNext());
            assertEquals("hello", iter.next());
            assertEquals(false, iter.hasNext());
            assertEquals("world", iter.next());
            assertEquals(false, iter.hasNext());
        }
    
        @Test
        public void testIteratorRemove() {
            SimpleLinkedList<String> list = new SimpleLinkedList<String>();
            list.add("first");
            list.add("second");
            list.add("third");

            // remove last element
            Iterator<String> iter = list.iterator();
            assertEquals("first", iter.next());
            assertEquals("second", iter.next());
            assertEquals("third", iter.next());
            iter.remove();
            assertEquals(2, list.size());

            //remove second element
            iter = list.iterator();
            assertEquals("first", iter.next());
            assertEquals("second", iter.next());
            iter.remove();
            assertEquals(1, list.size());

            //remove first element
            iter = list.iterator();
            assertEquals("first", iter.next());
            iter.remove();
            assertEquals(0, list.size());


        }

    
}
