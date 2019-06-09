package com.hillel.hw08.thread;

import com.hillel.hw08.collection.Collector;

public class ThreadSeparator {
    private int threads = 1;
    private Collector collector;

    public ThreadSeparator(Collector collector, int threads) {
        this.collector = collector;
        this.threads = threads;
    }

    public void separate(int from, int to) throws InterruptedException {
        int prepared = from > 1 ? from : 1;
        int batchSize = Math.round(to / threads);

        for (int i = prepared; i <= threads; i++) {
            int start = (i * batchSize) - (batchSize - 1);
            int finish = i * batchSize;

            System.out.println("start: " + start);
            System.out.println("finish: " + finish);

            Thread thread = new Thread(new ThreadWorker(collector, start, finish));
            thread.start();
            // thread.join();
        }
    }

    public int getThreads() {
        return threads;
    }

    public Collector getCollector() {
        return collector;
    }
}
