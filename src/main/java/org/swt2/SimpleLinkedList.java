/*
 * (c) 2013-2021  Heinrich Hussmann und Uwe Aßmann, TU Dresden
 */
package org.swt2;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * Achtung! Einige der Methoden sind fehlerhaft und müssen repariert werden.
 */
public class SimpleLinkedList<E> extends AbstractCollection<E> {
    private class Elem {
        private E elem;
        private Elem next;

        public Elem(E elem, Elem next) {
            this.elem = elem;
            this.next = next;
        }
    }

    private Elem start = null;
    private Elem end = null;
    private int size = 0;

    @Override
    public boolean add(E o) {
        Elem e = new Elem(o, null);
        if (start == null) {
            start = e;
            end = e;
        }
        if (end != null) {
            end.next = e;
        }
        end = e;
        size++;
        return true;
    }

    private boolean lremove(Elem toremove){

        if(toremove == start){
            start = start.next;
            size--;
            return true;
        }

        Elem tmp = start;

        while (toremove != tmp.next && tmp.next != null){
            tmp = tmp.next;
        }

        if(tmp.next == null){
            return false;
        }

        if(tmp.next.next == null){
            tmp.next = null;
            end = tmp;
        }else{
            tmp.next = tmp.next.next;
        }

        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    private class Iter implements Iterator<E> {
        private Elem current;
        private Elem last;

        public Iter() {
            current = start;
        }

        @Override
        public boolean hasNext() {
            if(current == null){
                return false;
            }
            return current.next != null;
        }

        @Override
        public E next() {
            if(current == null){
                throw new java.util.NoSuchElementException();
            }
            last = current;
            current = current.next;
            return last.elem;
        }

        @Override
        public void remove() {
            if(last == null){
                throw new IllegalStateException();
            }
            SimpleLinkedList.this.lremove(last);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }
}
