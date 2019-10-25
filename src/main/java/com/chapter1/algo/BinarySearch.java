package com.chapter1.algo;

public class BinarySearch {
    public static int search(int[] arr, int target) {
      return search(arr, 0, arr.length-1, target);
    }


    public static int search(int[] arr, int lo, int hl, int target) {
//      是否为递增数列
        boolean asc = true;

        if(arr == null || arr.length == 0 || lo < 0 || hl > arr.length - 1) {
            return -1;
        }

        if(arr[lo] > arr[hl]) {
            asc = false;
        }

        for(; lo <= hl;) {
            int mid = (lo+hl)/2;
            if(arr[mid] == target) {
                return mid;
            }
//            递增
            if(asc) {
                if(target < arr[mid]) {
                    hl = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                //            递减
                if(target < arr[mid]) {
                    lo = mid + 1;
                } else {
                    hl = mid - 1;
                }
            }
        }
        return -1;
    }

}
