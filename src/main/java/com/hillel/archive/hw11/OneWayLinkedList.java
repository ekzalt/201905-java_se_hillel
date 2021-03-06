package com.hillel.archive.hw11;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class OneWayLinkedList<E> implements Iterable<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public OneWayLinkedList() {
    }

    public OneWayLinkedList(E[] array) {
        this();
        addAll(array);
    }

    public Iterator<E> iterator() {
        return new OneWayLinkedListIterator<E>(getFirstNode());
    }

    public void addAll(E[] array) {
        for (E data : array) {
            addLast(data);
        }
    }

    public void add(E data) {
        addLast(data);
    }

    public void addLast(E data) {
        Node<E> current = last;
        last = new Node<>(data, null);

        if (current == null) {
            first = last;
        } else {
            current.next = last;
        }

        size++;
    }

    public void addFirst(E data) {
        Node<E> current = first;
        first = new Node<>(data, current);

        if (current == null) {
            last = first;
        }

        size++;
    }

    private void linkByIndex(int index, E data) {
        int position = 1;
        Node<E> previous = first;
        Node<E> current = first.next;

        while (position < index) {
            previous = current;
            current = current.next;
            position++;
        }

        Node<E> node = new Node<>(data, current);
        previous.next = node;
        size++;
    }

    public void addByIndex(int index, E data) {
        if (index > size) {
            throw new NoSuchElementException();
        } else if (index == size) {
            addLast(data);
        } else if (index == 0) {
            addFirst(data);
        } else {
            linkByIndex(index, data);
        }
    }

    public E removeLast() {
        if (last == null || first == null) {
            throw new NoSuchElementException();
        }

        E data = last.data;
        Node<E> previous = first;
        Node<E> current = first.next;

        while (current != null) {
            previous = current;
            current = current.next;
        }

        previous.next = null;
        last = previous;
        size--;

        return data;
    }

    public E removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        E data = first.data;
        first = first.next;
        size--;

        return data;
    }

    private E unlinkByIndex(int index) {
        int position = 1;
        Node<E> previous = first;
        Node<E> current = first.next;

        while (position < index) {
            previous = current;
            current = current.next;
            position++;
        }

        E data = current.data;
        previous.next = current.next;
        size--;

        return data;
    }

    public E removeByIndex(int index) {
        if (index >= size) {
            throw new NoSuchElementException();
        } else if (index == size - 1) {
            return removeLast();
        } else if (index == 0) {
            return removeFirst();
        } else {
            return unlinkByIndex(index);
        }
    }

    private void interLink(int firstIndex, int secondIndex) {
        int position = 1;
        Node<E> firstPairPrevious = first;
        Node<E> firstPairCurrent = first.next;

        while (position < firstIndex) {
            firstPairPrevious = firstPairCurrent;
            firstPairCurrent = firstPairCurrent.next;
            position++;
        }

        Node<E> firstPairLast = firstPairCurrent.next;

        position = 1;
        Node<E> secondPairPrevious = first;
        Node<E> secondPairCurrent = first.next;

        while (position < secondIndex) {
            secondPairPrevious = secondPairCurrent;
            secondPairCurrent = secondPairCurrent.next;
            position++;
        }

        Node<E> secondPairLast = secondPairCurrent.next;

        if (firstIndex + 1 == secondIndex) {
            firstPairPrevious.next = secondPairCurrent;
            secondPairCurrent.next = firstPairCurrent;
            firstPairCurrent.next = secondPairLast;
        } else {
            firstPairPrevious.next = secondPairCurrent;
            secondPairCurrent.next = firstPairLast;
            secondPairPrevious.next = firstPairCurrent;
            firstPairCurrent.next = secondPairLast;
        }
    }

    public void interChange(int firstIndex, int secondIndex) {
        if (firstIndex > secondIndex || firstIndex >= size || secondIndex >= size) {
            throw new NoSuchElementException();
        } else if (firstIndex == secondIndex) {
            return;
        } else {
            interLink(firstIndex, secondIndex);
        }
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (first == null) {
            return "[ ]";
        }

        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        Node<E> current = first;

        do {
            joiner.add(current.data.toString());
            current = current.next;
        } while (current != null);

        return joiner.toString();
    }

    public int getSize() {
        return size;
    }

    private Node<E> getFirstNode() {
        return first;
    }

    private Node<E> getLastNode() {
        return last;
    }

    public E getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        return getFirstNode().data;
    }

    public E getLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }

        return getLastNode().data;
    }
}
