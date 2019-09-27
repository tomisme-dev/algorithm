package com.chapter1.exercise;

public class Ex_1_1_18 {
    public static void main(String[] args) {
        System.out.println("(2, 25) = " + mystery(2, 25));
        System.out.println("(3, 11) = " + mystery(3, 11));
        System.out.println("(8, 11) = " + mystery(8, 11));
    }

    public static int mystery(int a, int b) {
        if(b == 0) {
            return 0;
        }

        if(b % 2 == 0) {
            return mystery(a + a, b/2);
        }

        return mystery(a + a, b/2) + a;
    }
}
