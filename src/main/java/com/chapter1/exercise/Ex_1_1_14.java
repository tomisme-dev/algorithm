package com.chapter1.exercise;

public class Ex_1_1_14 {
    public static void main(String[] args) {
        int val = lg(1025);
        System.out.println(val);
    }
    public static int lg(int N) {
        int count = 0;
        int mul = 1;
        while(true) {
            mul *= 2;
            if(mul > N) {
                break;
            }
            count++;
        }
        return count;
    }
}
