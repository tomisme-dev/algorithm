package com.chapter1.algo;

import edu.princeton.cs.algs4.StdDraw;

import java.util.*;

public abstract class TimeCalc {
    private Map<Integer, Long> plan = new TreeMap<>();
    private int[] defaultSizes = {1000, 2000, 5000, 10000, 50000, 100000, 1000000};

    public TimeCalc() {
        for(int size: defaultSizes) {
            plan.put(size, 0L);
        }
    }

    public TimeCalc(int[] sizes) {
        for(int size: sizes) {
            plan.put(size, 0L);
        }
    }

    /**
     * @return 返回运行消耗的毫秒时间
     * */
    public abstract Long task(int size);

    public void start() {
        for(Integer size: plan.keySet()) {
            Long times = task(size);
            plan.put(size, times);
        }
    }

    public void drawGraph() {
        System.out.println(plan);
        Integer maxX = plan.keySet().stream().max((a, b) -> a-b).get();
        Long maxY = plan.values().stream().max((a, b) -> Long.compare(a, b)).get();
        StdDraw.setXscale(0, maxX);
        StdDraw.setYscale(0, Integer.valueOf(maxY.toString()));
        StdDraw.setPenRadius(0.01);
        plan.forEach((k, v) -> {
            StdDraw.point(k, v);
        });
    }
}
