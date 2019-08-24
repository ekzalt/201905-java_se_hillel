package com.hillel.archive.hw08.thread;

import com.hillel.archive.hw08.collection.Collector;
import com.hillel.archive.hw08.math.MathOperator;

public class ThreadWorker implements Runnable {
    private MathOperator operator = new MathOperator();

    private Collector collector;
    private int from = 1;
    private int to = 1;

    public ThreadWorker(Collector collector, int from, int to) {
        this.collector = collector;
        this.from = from;
        this.to = to;
    }

    private void collectSimple(int from, int to) {
        collector.pushAll(operator.collectSimple(from, to));
    }

    @Override
    public void run() {
        collectSimple(from, to);
    }
}
