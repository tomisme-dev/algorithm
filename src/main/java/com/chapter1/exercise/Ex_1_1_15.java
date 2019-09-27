package com.chapter1.exercise;

import java.util.Arrays;

public class Ex_1_1_15 {

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,3,0,0};
        System.out.println(Arrays.toString(histogram(arr, 2)));
    }

    public static int[] histogram(int[] arr, int M) {
        int[] result = new int[M];
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if(val >= 0 && val < M) {
                result[val]++;
            }
        }
        return result;
    }
}
