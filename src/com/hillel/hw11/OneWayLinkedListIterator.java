package com.hillel.hw11;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OneWayLinkedListIterator<E> implements Iterator<E> {
    public int position;
    public Node<E> element;

    public OneWayLinkedListIterator(Node<E> first) {
        position = 0;
        element = first;
    }

    public boolean hasNext() {
        return element != null;
    }

    public E next() {
        if (element == null) {
            throw new NoSuchElementException();
        }

        E data = element.data;
        element = element.next;
        position++;

        return data;
    }
}
