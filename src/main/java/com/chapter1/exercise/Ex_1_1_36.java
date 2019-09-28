package com.chapter1.exercise;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Random;

public class Ex_1_1_36 {
    public static void main(String[] args) {
        int[] src = {9,5,6,7,8,4};
        int[] arr = {4,5,6,7,8,9};
//      尝试次数
        int N = 1000000;
        int count = 0;
        for(int i = 0; i < N; i++) {
//            StdRandom.shuffle(arr);
            shuffle(arr);
            if(arrayEquals(arr, src)) {
                count++;
            }
        }

        System.out.println("target posible: " + (1.0)/jc(arr.length));
        System.out.println(count*1.0/N);
    }

    public static int jc(int n) {
        int val = 1;
        for(int i = 1; i <= n; i++) {
            val *= i;
        }
        return val;
    }

    public static boolean arrayEquals(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length) {
            return false;
        }

        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }


    public static void shuffle(int[] arr) {
        Random random = new Random();
        for(int i = 0; i < arr.length; i++) {
            int r = random.nextInt(arr.length);
            int tmp = arr[i];
            arr[i] = arr[r];
            arr[r] = tmp;
        }
    }
}
