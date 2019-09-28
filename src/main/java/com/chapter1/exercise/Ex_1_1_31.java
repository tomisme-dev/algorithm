package com.chapter1.exercise;

import edu.princeton.cs.algs4.StdDraw;

import java.sql.Time;

public class Ex_1_1_31 {
    public static void main(String[] args) {
        StdDraw.setXscale(-1.5, 1.5);
        StdDraw.setYscale(-1.5, 1.5);
        StdDraw.setPenRadius(.01);
//        StdDraw.circle(0, 0, 1);
        StdDraw.line(0, -100, 0, 100);
        StdDraw.line( -100, 0, 100, 0);


        int N = 6;
        double seda = Math.PI * 2.0 / N;
//      偏转度数
        double delta = 0;
        while (delta < Math.PI/2) {
            for(int i = 1; i <= N; i++) {
                double x = 1 * Math.cos(seda * i + delta);
                double y = 1 * Math.sin(seda * i + delta);
                StdDraw.point(x, y);
            }
            delta+=Math.PI/1000;
        }

    }
}
