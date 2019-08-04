package com.hillel.hw08.thread;

import com.hillel.hw08.collection.Collector;

public class ThreadSeparator {
    private int threads = 1;
    private Collector collector;
    private int threadCounter;

    public ThreadSeparator(Collector collector, int threads) {
        this.collector = collector;
        this.threads = threads;
    }

    public void separate(int from, int to) throws InterruptedException {
        int batchSize = Math.round(to / threads);
        Thread[] workers = new Thread[threads];
        threadCounter = 0;

        for (int i = threadCounter; i < threads; i++) {
            int start = ((i+1) * batchSize) - (batchSize - 1);
            int finish = (i+1) * batchSize;

            System.out.println("start: " + start);
            System.out.println("finish: " + finish);

            from = from > start ? from : start;
            Thread thread = new Thread(new ThreadWorker(collector, from, finish));
            workers[i] = thread;
            thread.start();
        }

        for (Thread thread : workers) {
            thread.join();
        }
    }

    public int getThreads() {
        return threads;
    }

    public Collector getCollector() {
        return collector;
    }
}
