package com.chapter1.exercise;

import edu.princeton.cs.algs4.In;

public class Ex_1_2_15 {
    public static void main(String[] args) {
        int[] ints = readInts("largeT.txt");
        System.out.println(ints.length);
    }

    public static int[] readInts(String filename) {
        In in = new In(filename);
        String s = in.readAll();
        String[] words = s.split("\\s+");
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = Integer.parseInt(words[i]);
        }

        return result;
    }
}
