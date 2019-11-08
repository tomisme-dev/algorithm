package com.chapter1.exercise;

import com.chapter1.algo.IntGenerator;

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
            if (target == arr[second]) {
                return second;
            } else if(target > arr[second]) {
                first = second+1;
                int tmp = add1;
                add1 = add2;
                add2 = add1 + tmp;
            } else if(arr[first] > target) {
                return -1;
            } else {
//                int tmp = add2 - add1;
//                add2 = add1;
//                add1 = tmp;
                int k4 = add2;
                int k3 = add1;
                int k2 = k4- k3;
                int k1 = k3 - k2;
                add2 = k2;
                add1 = k1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = IntGenerator.generate(30);
        Arrays.sort(ints);
        for(int i: ints) {
            int index = find(ints, i);
            System.out.println( "[" + index + "] = " + i );
        }

        System.out.println(find(ints, ints[0] - 100));
        System.out.println(find(ints, ints[ints.length - 1] + 100));

        System.out.println(find(ints, ints[ints.length/2] + 100));
    }


}
