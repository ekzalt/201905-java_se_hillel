package com.hillel.hw11;

public class ListRunner {
    public void run() {
        OneWayLinkedList<Integer> list = new OneWayLinkedList<>(new Integer[]{10,20,30,40});
        OneWayLinkedListIterator<Integer> iterator = list.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
