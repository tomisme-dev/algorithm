package com.chapter1.algo;

public class ThreeSum extends TimeCalc{
    public ThreeSum(int[] ints) {
        super(ints);
    }

    public ThreeSum() {
    }

    public static void main(String[] args) {
        int[] sizes = new int[] {1000, 2000, 4000};

        ThreeSum threeSum = new ThreeSum(sizes);
        threeSum.start();
        threeSum.drawGraph();
    }

    @Override
    public Long task(int size) {
        int[] ints = IntGenerator.generate(size);
        int sum = 0;

        long start = System.currentTimeMillis();
        count(ints);
        return System.currentTimeMillis() - start;
    }

    public int count(int[] ints) {
        int size = ints.length;
        int sum = 0;
        for(int i = 0; i < size; i++) {
            for(int j = i+1; j < size; j++) {
                for(int k = j+1; k < size; k++) {
                    sum += (ints[i] + ints[j] + ints[k]);
                }
            }
        }

        return sum;
    }

}
