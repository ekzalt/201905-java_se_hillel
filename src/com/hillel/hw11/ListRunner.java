package com.hillel.hw11;

public class ListRunner {
    public void run() {
        OneWayLinkedList<Integer> list = new OneWayLinkedList<>(new Integer[]{10,20,30,40});
        System.out.println("size: " + list.getSize() + ", first: " + list.getFirst() + ", last: " + list.getLast());
        System.out.println(list);

        list.addFirst(1);
        list.addLast(100);
        System.out.println(list);

        list.addByIndex(1, 2);
        System.out.println(list);

        list.removeByIndex(1);
        System.out.println(list);

        list.interChange(1, 4);
        System.out.println(list);
    }
}
