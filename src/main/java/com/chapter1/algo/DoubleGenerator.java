package com.chapter1.algo;

import java.util.Random;

public class DoubleGenerator {
    private static Random random = new Random();
    public static double[] generate(int size, double min, double max) {
        if(size <= 0) {
            throw new IllegalArgumentException("size must greater than 0");
        }
        double[] result = new double[size];
        for(int i = 0; i < size; i++) {
            result[i] = random.nextDouble() * (max - min) + min;
        }
        return result;
    }
}
