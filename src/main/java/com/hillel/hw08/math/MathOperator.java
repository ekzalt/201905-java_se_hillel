package com.hillel.hw08.math;

import com.hillel.hw08.collection.Collector;

public class MathOperator {
    public int[] collectSimple(int from, int to) {
        Collector collector = new Collector(new int[0]);

        for (int i = 2; i <= to; i++) {
            boolean isSimple = true;

            for (int j = 2; j <= to; j++) {
                if (i != j && i % j == 0) {
                    isSimple = false;
                    break;
                }
            }

            if (isSimple && i >= from) {
                collector.push(i);
            }
        }

        return collector.getResult();
    }
}
