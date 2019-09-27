package com.chapter1.exercise;

public class Ex_1_1_22 {


    public static int binarySearch(int[] arr, int low, int heigh, int val, int depth) {
        System.out.println("depth:" + depth + ", [" + low + "," + heigh + "]");
        if(low >= heigh) {
            return -1;
        }
        int mid = (low + heigh)/2;
        if(val < arr[mid]) {
            return binarySearch(arr, low, mid, val, depth+1);
        } else if(val == arr[mid]) {
          return mid;
        } else {
            return binarySearch(arr, mid, heigh, val, depth+1);
        }
    }
}
