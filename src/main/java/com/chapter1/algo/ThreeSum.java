package com.chapter1.algo;

import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum extends TimeCalc{
    public ThreeSum(int[] ints) {
        super(ints);
    }

    public ThreeSum() {
    }

    public static void main(String[] args) {
        int[] sizes = new int[] {1000, 5000};
//
        ThreeSum threeSum = new ThreeSum(sizes);
//        threeSum.start();
//        threeSum.drawGraph();

        List<Point> countPoints= new ArrayList<>(sizes.length);
        List<Point> count2Points= new ArrayList<>(sizes.length);
        for(int size: sizes) {
            int[] ints = IntGenerator.generate(size);
            Stopwatch stopwatch = new Stopwatch();
            int count1 = threeSum.count(ints);
            double t1 = stopwatch.elapsedTime();

            stopwatch = new Stopwatch();
            int count2 = threeSum.count2(ints);
            double t2 = stopwatch.elapsedTime();
            countPoints.add(Point.of(size, t1));
            count2Points.add(Point.of(size, t2));
            System.out.println(count1 + "====>" + count2);
        }
        System.out.println(countPoints);
        System.out.println(count2Points);
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
        int count = 0;
        for(int i = 0; i < size; i++) {
            for(int j = i+1; j < size; j++) {
                for(int k = j+1; k < size; k++) {
                    if(ints[i] + ints[j] + ints[k] == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public int count2(int[] ints) {
        Arrays.sort(ints);
        int size = ints.length;
        int count = 0;
        for(int i = 0; i < size; i++) {
            for(int j = i+1; j < size; j++) {
                int remain = 0-(ints[i] + ints[j]);
                int index = binaySearch(ints, j + 1, ints.length - 1, remain);
                if(index >= 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private int binaySearch(int[] ints, int first, int last, int target) {

        for(; first <= last; ) {
            int mid = (first + last)/2;
            if(ints[mid] == target) {
                return mid;
            } else if(target < ints[mid]) {
                last = mid -1;
            } else {
                first = mid + 1;
            }
        }

        return -1;
    }

    private static class Point {
        double x;
        double y;
        static Point of(double x, double y) {
            Point point = new Point();
            point.x = x;
            point.y = y;
            return point;
        }

        @Override
        public String toString() {
            return String.format("(%f,%f)", x, y);
        }
    }

}
