package com.chapter1.exercise;

public class Ex_1_1_24 {
    public static void main(String[] args) {
        System.out.println(greaterCommonDivisor(105, 24));
        System.out.println(greaterCommonDivisor(1111111, 1234567));
        System.out.println(greaterCommonDivisor2(105, 24));
        System.out.println(greaterCommonDivisor2(1111111, 1234567));
    }

    public static int greaterCommonDivisor(int p, int q) {
        int max = Math.max(p, q);
        int min = Math.min(p, q);
        System.out.printf("(%d, %d)\n", max, min);
        if(max % min == 0) {
            return min;
        }
        return greaterCommonDivisor(min, max % min);
    }

    public static int greaterCommonDivisor2(int p, int q) {
        int max = Math.max(p, q);
        int min = Math.min(p, q);
        System.out.printf("(%d, %d)\n", max, min);
        if(max % min == 0) {
            return min;
        }
        return greaterCommonDivisor(min, max - min);
    }
}
