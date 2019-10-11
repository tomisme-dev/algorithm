package com.chapter1.exercise;

import com.chapter1.da.Node;
import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Random;

public class Ex_1_1_39 {
    private String s = "hello world";
    public static void main(String[] args) {
        Ex_1_1_39 ex = new Ex_1_1_39();
        System.out.println(ex);

//        int t = Integer.valueOf(args[0]);
        int t = 1000;
        int[] sizes = {1000, 10000, 100000, 1000000};

        for(int index = 0; index < sizes.length; index++) {
            int size = sizes[index];
//            重复t次，求平均值
            int sumCount = 0;
            for(int i = 1; i <= t; i++) {
                int count = sameValueCount(1000);
                sumCount += count;
            }
            System.out.println("数组大小:" + size + ", 重复次数: " + t + ", 相同次数平均数: " + (sumCount*1.0/t));
        }

    }

    public static int sameValueCount(int size) {
        int[] arr1 = new int[size];
        int[] arr2 = new int[size];
//      设置六位数随机数
        for(int i = 0; i < size; i++) {
            arr1[i] = 100000 + StdRandom.uniform(900000);
            arr2[i] = 100000 + StdRandom.uniform(900000);
        }
//        查找同时出现在这两个数组中的个数
//        先排序
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int sameCount = 0;
        for(int i = 0; i < size; i++) {
            int index = BinarySearch.indexOf(arr2, arr1[i]);
            if(index >= 0) {
                sameCount++;
            }
        }
        return sameCount;
    }

}
