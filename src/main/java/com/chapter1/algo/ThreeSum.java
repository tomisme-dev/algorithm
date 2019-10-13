package com.chapter1.algo;

public class ThreeSum extends TimeCalc{
    public ThreeSum(int[] ints) {
        super(ints);
    }

    public static void main(String[] args) {
        int l = 5;
        int[] sizes = new int[l];
        for(int i = 1; i <= l; i++) {
            sizes[i-1] = 1000*i;
        }
        ThreeSum threeSum = new ThreeSum(sizes);
        threeSum.start();
        threeSum.drawGraph();
    }

    @Override
    public Long task(int size) {
        int[] ints = IntGenerator.generate(size);
        int sum = 0;

        long start = System.currentTimeMillis();
        for(int i = 0; i < size; i++) {
            for(int j = i+1; j < size; j++) {
                for(int k = j+1; k < size; k++) {
                    sum += (ints[i] + ints[j] + ints[k]);
                }
            }
        }

        return System.currentTimeMillis() - start;
    }

}
