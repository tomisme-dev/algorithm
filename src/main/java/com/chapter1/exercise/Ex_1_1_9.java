package com.chapter1.exercise;

public class Ex_1_1_9 {
    public static void main(String[] args) {
        System.out.println(binary(0));
        System.out.println(binary(1));
        System.out.println(binary(2));
        System.out.println(binary(158));
    }

    public static String binary(int value) {
        String result = "";
        while(value > 0) {
            result = (value % 2) + result;
            value = value >> 1;
        }
        return result;
    }
}
