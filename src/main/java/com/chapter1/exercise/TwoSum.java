package com.chapter1.exercise;

import com.chapter1.algo.IStopwatch;
import com.chapter1.algo.IntGenerator;
import com.chapter1.algo.Stopwatch;
import com.chapter1.algo.TimeCalc;

public class TwoSum extends TimeCalc {
    @Override
    public double task(int size) {
        int[] ints = IntGenerator.generate(size);
        int count = 0;
        IStopwatch stopwatch = new Stopwatch();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if(ints[i] + ints[j] == 0) {
                    count++;
                }
            }
        }
        return stopwatch.elapsedTime();
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int len = 20;
        int[] sizes = new int[len];
        for(int n = 500, i = 0; i < len; i++, n *= 2) {
            sizes[i] = n;
        }
        twoSum.setPlan(sizes);
        twoSum.start();
    }
}
