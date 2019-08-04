package com.hillel.hw08.collection;

public class Collector {
    private int[] result = new int[0];
    private boolean inProgress = false;
    private int counter = 0;

    public Collector(int[] initial) {
        this.result = initial;
    }

    public void push(int item) {
        result = resizeAndPush(result, item);
    }

    private int[] resizeAndPush(int[] list, int item) {
        int[] copy = new int[list.length + 1];

        for (int i = 0; i < list.length; i++) {
            copy[i] = list[i];
        }

        copy[copy.length - 1] = item;
        return copy;
    }

    synchronized public void pushAll(int[] items) {
        for (int simple : items) {
            push(simple);
        }

        counter++;
        System.out.println("synchronized called: " + counter);
    }

    public int[] getResult() {
        return result;
    }

    public int getCounter() {
        return counter;
    }
}
