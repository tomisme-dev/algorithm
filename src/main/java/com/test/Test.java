package com.test;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;

public class Test {
    public String name = "ccc";
    {
        name = "hello";
    }

    public Test() {
        name = "gogo";
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("hello world!!");
//        int i = 0;
//        i++;
//        i = i + 1;
//        double[] a;
//        a = new double[10];
//        double[] b = {1.1, 2.2, 3.3};
//        double[][] a = {{1.1, 2.1}, {3.1, 4.1}, {5.1, 6.1}};
//        System.out.println(a[0]);
//        System.out.println(sqrt(2));
//        String s = "1";
//        s = "abc" + sqrt(12);
//        int N = 100;
//        StdDraw.setXscale(0, N);
//        StdDraw.setYscale(0, N*N);
//        StdDraw.setPenRadius(.01);
//        for(int i = 1; i <= N; i++) {
//            StdDraw.point(i, i);
//            StdDraw.point(i, i*i);
//            StdDraw.point(i, i * Math.log(i));
//        }
//        drawRandom();
//        genLargeWTxt("largeT.txt", 10000000);
        int x = -2147483648;
        double d = 1.0/0/0;
        System.out.println(-14%3);
        System.out.println(14%-3);
        System.out.println(2.0e-6*100000000.1);
        System.out.println(true && false || true && true);
        System.out.println(Math.abs(x));
    }


    public static void genLargeWTxt(String fileName, int size) throws FileNotFoundException {
        Random random = new Random();
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        Out out = new Out(fileOutputStream);
        for(int i = 0; i < size; i++) {
            int val = random.nextInt(100000);
            out.println(val);
        }
        out.close();
    }

    public static void drawRandom() {
        int N = 50;
        double[] a = new double[N];
        for(int i = 0; i < N; i++) {
            a[i] = StdRandom.random();
        }

        StdDraw.setXscale(-1, 2);
        StdDraw.setYscale(0, 1);

        for(int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i]/2.0;
            double rw = 0.1/N;
            double rh = a[i]/2.0;
            System.out.println(a[i]);
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    public static double sqrt(double c) {
        double x = c;
        double precious = 1e-8;
        while(Math.abs(x * x - c) > precious) {
            x = (x * x + c)/(2*x);
        }
        return x;
    }
}
