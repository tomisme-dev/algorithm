package com.chapter1.algo;

import edu.princeton.cs.algs4.StdDraw;

import java.util.*;

public abstract class TimeCalc {
    private Map<Integer, Double> plan = new TreeMap<>();
    private int[] defaultSizes = {500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 256000, 512000, 1020000};

    public TimeCalc() {
        for(int size: defaultSizes) {
            plan.put(size, 0D);
        }
    }

    public TimeCalc(int[] sizes) {
        for(int size: sizes) {
            plan.put(size, 0D);
        }
    }

    public void setPlan(int[] sizes) {
        plan = new TreeMap<>();
        for(int size: sizes) {
            plan.put(size, 0D);
        }
    }

    /**
     * @return 返回运行消耗的毫秒时间
     * */
    public abstract double task(int size);

    public void start() {
        System.out.printf("%14s %14s %14s\n", "size", "time", "half");
        double preTimes = 1;
        for(Integer size: plan.keySet()) {
            double times = task(size);
            System.out.printf("%14d,%14.7f,%14.7f\n", size, times, times/preTimes);
            plan.put(size, times);
            preTimes = times;
        }
    }

    public void drawGraph() {
        System.out.println(plan);
        Integer maxX = plan.keySet().stream().max((a, b) -> a-b).get();
        Double maxY = plan.values().stream().max((a, b) -> Double.compare(a, b)).get();
        StdDraw.setXscale(0, maxX);
        StdDraw.setYscale(0, Integer.valueOf(maxY.toString()));
        StdDraw.setPenRadius(0.01);
        plan.forEach((k, v) -> {
            StdDraw.point(k, v);
        });
    }
}
