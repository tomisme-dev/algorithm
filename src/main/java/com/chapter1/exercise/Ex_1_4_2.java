package com.chapter1.exercise;

import edu.princeton.cs.algs4.DoublingTest;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Map;

public class Ex_1_4_2 {
    public static void main(String[] args) {
        StdDraw.setPenRadius(0.01);
        StdDraw.setXscale(-20, 20);
        StdDraw.setYscale(-20, 20);
        StdDraw.line(0, -100, 0, 100);
        StdDraw.line(-100, 0, 100, 0);
        for (int n = 250; true; n += n) {
            double time = DoublingTest.timeTrial(n);
            StdOut.printf("%7d %7.1f\n", n, time);
            double x = Math.log(n);
            double y = Math.log(time);
            StdDraw.point(x, y);
            System.out.println("x=" + x + ", y=" + y);
        }
    }
}
