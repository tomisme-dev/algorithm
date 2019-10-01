package com.chapter1.da;

public class Accumulator {
    private double total;
    private int N;

    public void addDataValue(Double val) {
        N++;
        total += val;
    }

    public double mean() {
        return total/N;
    }

    @Override
    public String toString() {
        return String.format("Mean (%d values): %.5f", N, total/N);
    }

}
