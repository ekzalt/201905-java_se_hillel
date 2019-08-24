package com.hillel.archive.hw08;

import com.hillel.archive.hw08.collection.Collector;
import com.hillel.archive.hw08.thread.ThreadSeparator;

import java.util.Scanner;

public class ScannerReader {
    private int THREADS = 5;
    private Scanner scanner;

    public void run() {
        System.out.println("Enter integers range, for example: 1 5000");
        scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (scanner != null) {
                scanner.close();
            }

            String[] args = line.split(" ");
            int from = Integer.parseInt(args[0]);
            int to = Integer.parseInt(args[1]);
            Collector collector = new Collector(new int[0]);
            ThreadSeparator separator = new ThreadSeparator(collector, THREADS);

            try {
                separator.separate(from, to);

                /*
                while (collector.getCounter() < THREADS) {
                    System.out.println("sleep");
                    Thread.sleep(10);
                }
                 */
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i: collector.getResult()) {
                System.out.println("simple: " + i);
            }
        }
    }
}
