package com.chapter1.exercise;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ex_1_2_1 {
    public static void main(String[] args) {
        int n = 30;
        Point2D[] points = new Point2D[n];
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.setPenRadius(0.001);
        for(int i = 0; i < n; i++) {
            points[i] = new Point2D(StdRandom.random(), StdRandom.random());
            points[i].draw();
        }

//        找到最近的两个点
        double minDistance = points[0].distanceSquaredTo(points[1]);
        Point2D pointA = points[0];
        Point2D pointB = points[1];
        for (int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(points[i].distanceSquaredTo(points[j]) < minDistance) {
                    minDistance = points[i].distanceSquaredTo(points[j]);
                    pointA = points[i];
                    pointB = points[j];
                }
            }
        }

//        画出这两点
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(pointA.x(), pointA.y(), pointB.x(), pointB.y());

    }
}
