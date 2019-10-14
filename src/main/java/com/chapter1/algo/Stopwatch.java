package com.chapter1.algo;

import edu.princeton.cs.algs4.DoublingTest;

public class Stopwatch implements IStopwatch {
    private long startTimeMillis = System.currentTimeMillis();

    @Override
    public double elapsedTime() {
        return (System.currentTimeMillis() - startTimeMillis)/1000D;
    }

    public static void main(String[] args) {
        int[] generate = IntGenerator.generate(1000);
        ThreeSum threeSum = new ThreeSum();
        Stopwatch stopwatch = new Stopwatch();
        threeSum.count(generate);
        System.out.println(stopwatch.elapsedTime());

        DoublingTest.main(new String[1]);
    }
}
