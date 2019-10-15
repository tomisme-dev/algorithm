package com.chapter1.algo;

import java.util.Random;

public class IntGenerator {
    private static Random random = new Random();
    public static int[] generate(int size) {
        if(size <= 0) {
            throw new IllegalArgumentException("size must greater than 0");
        }
        int[] result = new int[size];
        for(int i = 0; i < size; i++) {
            result[i] = random.nextInt(2000001) - 1000000;
        }
        return result;
    }
}
