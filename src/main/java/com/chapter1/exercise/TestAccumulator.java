package com.chapter1.exercise;

import com.chapter1.da.Accumulator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class TestAccumulator {
    public static void main(String[] args) {
        int t = Integer.valueOf(args[0]);
        Accumulator accumulator = new Accumulator();
        for (int i = 0; i < t; i++) {
            accumulator.addDataValue(StdRandom.random());
        }
        StdOut.println(accumulator);
    }
}
