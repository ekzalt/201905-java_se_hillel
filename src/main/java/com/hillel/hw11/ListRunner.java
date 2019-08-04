package com.hillel.hw11;

import java.util.Iterator;

public class ListRunner {
    public void run() {
        OneWayLinkedList<Integer> list = new OneWayLinkedList<>(new Integer[]{10,20,30,40});
        for (Integer i : list) {
            System.out.println(i);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}
