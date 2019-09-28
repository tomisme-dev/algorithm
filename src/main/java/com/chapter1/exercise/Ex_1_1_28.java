package com.chapter1.exercise;

import java.util.Arrays;

public class Ex_1_1_28 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,1,2,5,99,7,0,3,1};
        Arrays.sort(arr);
        int[] notDuplicate = removeDuplicate(arr);
        System.out.println(Arrays.toString(notDuplicate));
    }

    public static int[] removeDuplicate(int[] arr) {
        int[] result = new int[arr.length];
        int size = 0;
        result[size++] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != result[size-1]) {
                result[size++] = arr[i];
            }
        }

        int[] val = new int[size];
        System.arraycopy(result,0, val, 0, size);
        return val;
    }
}
