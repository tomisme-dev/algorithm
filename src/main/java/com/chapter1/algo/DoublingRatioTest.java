package com.chapter1.algo;

import edu.princeton.cs.algs4.DoublingRatio;

public class DoublingRatioTest {
    public static void main(String[] args) {
//        DoublingRatio.main(null);

        ThreeSum threeSum = new ThreeSum();
        int size = 250;
        int[] ints = IntGenerator.generate(size);
        IStopwatch stopwatch = new Stopwatch();
        threeSum.count2(ints);
        double prevTimes = stopwatch.elapsedTime();
        for(int n = size * 2; true; n *= 2) {
            ints = IntGenerator.generate(n);
            stopwatch = new Stopwatch();
            threeSum.count2(ints);
            double curTimes = stopwatch.elapsedTime();
            System.out.printf("%20d%20f%10f\n", n, curTimes, (curTimes/prevTimes));
            prevTimes = curTimes;
        }

    }
}
