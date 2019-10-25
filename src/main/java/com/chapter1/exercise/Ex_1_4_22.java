package com.chapter1.exercise;

import java.util.Arrays;

public class Ex_1_4_22 {
    public static int find(int[] arr, int target) {
        int add1 = 0;
        int add2 = 1;

        for(int first=0; first < arr.length && add2 > 0; ) {
            if(arr[first] == target) {
                return first;
            }

            int second = first + add2;
            second = Integer.min(second, arr.length-1);
            if(target > arr[second]) {
                first = second;
                int tmp = add1;
                add1 = add2;
                add2 = add1 + tmp;
            } else if(arr[first] > target) {
                return -1;
            } else {
                int tmp = add2 - add1;
                add2 = add1;
                add1 = tmp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int i = find(arr, 5);
        System.out.println(i);
    }


}
