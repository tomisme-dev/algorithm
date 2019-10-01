package com.chapter1.da;

import edu.princeton.cs.algs4.StdDraw;

public class VisualAccumulator {
    private int trials;
    private double max;
    private double total;
    private int N;

    public VisualAccumulator(int trials, double max) {
        this.trials = trials;
        this.max = max;
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(0.005);
    }

    public void addDataValue(double value) {
        total += value;
        N++;
//        画当前点
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N, value);
//        画平均数点
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N, avg());
    }

    public double avg() {
        return total/N;
    }

    @Override
    public String toString() {
        return String.format("count=%d, avg=%.5f", N, avg());
    }
}
