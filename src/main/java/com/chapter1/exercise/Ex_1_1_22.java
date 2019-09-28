package com.chapter1.exercise;

import java.util.Arrays;

public class Ex_1_1_22 {
    public static void main(String[] args) {
        int[] arr = {8,6,4,5,3,1,2,10,32,15,14};
        Arrays.sort(arr);
        System.out.println(binarySearch(arr, 0, arr.length-1, 8, 1));
    }


    public static int binarySearch(int[] arr, int low, int heigh, int val, int depth) {
        System.out.println("depth:" + depth + ", [" + low + "," + heigh + "]");
        if(low > heigh) {
            return -1;
        }
        int mid = (low + heigh)/2;
        if(val < arr[mid]) {
            return binarySearch(arr, low, mid-1, val, depth+1);
        } else if(val == arr[mid]) {
          return mid;
        } else {
            return binarySearch(arr, mid+1, heigh, val, depth+1);
        }
    }
}
