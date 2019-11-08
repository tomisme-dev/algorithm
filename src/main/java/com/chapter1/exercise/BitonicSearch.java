package com.chapter1.exercise;

import com.chapter1.algo.*;

import java.util.Arrays;
import java.util.Random;

public class BitonicSearch extends TimeCalc {
    private Random rand = new Random();

    @Override
    public double task(int size) {
        int size1 = rand.nextInt(size - 4) + 2;
        int[] ints1 = IntGenerator.generate(size1, 0, 1000);
        Arrays.sort(ints1);
        int[] ints2 = IntGenerator.generate(size - size1, 0, 1000);
        Arrays.sort(ints2);
        int[] ints = new int[size];
        for(int i = 0; i < ints1.length; i++) {
            ints[i] = ints1[i];
        }

        for(int i = ints1.length, j = ints2.length - 1; i < ints.length; i++, j--) {
            ints[i] = ints2[j];
        }
//        System.out.println(Arrays.toString(ints));

        int targetIndex = rand.nextInt(ints.length);
//        System.out.println("target>>" + ints[targetIndex]);
        IStopwatch stopwatch = new Stopwatch();
        int index = find2(ints, ints[targetIndex]);
        System.out.println("index>>" + index);
        return stopwatch.elapsedTime();
    }

    private static int find(int[] arr, int lo, int hl, int target) {
        if(lo > hl) {
            return -1;
        }

        int mid = (lo + hl)/2;
        if(arr[mid] == target) {
            return mid;
        }

//        判断左边是增,还是减
        if(arr[mid] > arr[mid-1]) {
//            左边是增, 右边增/减
//            从左边找
            if(target < arr[mid]) {
                int index = find(arr, 0, mid-1, target);
                if(index != -1) {
                    return index;
                }
            } else {
                //            从右边找
                int index = find(arr, mid + 1, hl, target);
                if(index != -1) {
                    return index;
                }
            }
        } else if(arr[mid] < arr[mid-1]) {
//            左边是增/减, 右边是减
//            从右边找
            if(target < arr[mid]) {
                int index = find(arr, mid + 1, hl, target);
                if(index != -1) {
                    return index;
                }
            } else {
//            从左边找
                int index = find(arr, 0, mid-1, target);
                if(index != -1) {
                    return index;
                }
            }

        } else {
//            报错, 不能重复
            throw new IllegalArgumentException("数据不能有重复数据:" + arr[mid]);
        }
        return -1;
    }


    private static int find2(int[] arr, int target) {
//        先找到最大值
        int maxIndex = 0;
        for(int lo = 0, hl = arr.length - 1; lo <= hl;) {
            int mid = (lo+hl)/2;
            if(arr[mid] >= arr[mid+1] && arr[mid] >= arr[mid-1]) {
                maxIndex = mid;
                break;
            }
            if(arr[mid-1] > arr[mid]) {
                hl = mid - 1;
            }
            if(arr[mid+1] > arr[mid]) {
                lo = mid + 1;
            }
        }

//        System.out.println("maxIndex:" + maxIndex + ",maxValue:" + arr[maxIndex]);
//        先从左边找
        int index = BinarySearch.search(arr, 0, maxIndex, target);
        if(index >= 0) {
            return index;
        }
//        从右边找
        index = BinarySearch.search(arr, maxIndex+1, arr.length-1, target);

        return index;
    }




    public static void main(String[] args) {
        BitonicSearch bitonicSearch = new BitonicSearch();
//        bitonicSearch.task(20);
//        bitonicSearch.start();
        int n = 100;
        System.out.println(Math.log(n));
        System.out.println(Math.log(n)/Math.log(2));
        for(int i = 1; i < n; i++) {
            double y = i * Math.pow(n, 1.0/i);
            System.out.println("x=" + i + ", y=" + y);
        }
    }
}
