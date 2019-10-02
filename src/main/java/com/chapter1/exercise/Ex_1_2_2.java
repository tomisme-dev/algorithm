package com.chapter1.exercise;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdDraw;

public class Ex_1_2_2 {
    public static void main(String[] args) {
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.setPenRadius(0.01);

        Interval1D i1 = new Interval1D(0.1, 0.5);
        Interval1D i2 = new Interval1D(0.4, 0.8);

        Interval1D i3 = new Interval1D(0.6, 0.8);

        System.out.println(i1.intersects(i2));
        System.out.println(i1.intersects(i3));
    }
}
