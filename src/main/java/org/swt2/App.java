package org.swt2;

public class App {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(2);

        System.out.println(list);
    }
}
