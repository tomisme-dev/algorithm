package com.chapter1.exercise;

import java.util.Arrays;

public class StaticSETofInts {
    private int[] values;

    public StaticSETofInts(int[] values) {
        this.values = values;
        Arrays.sort(values);
    }

    public static void main(String[] args) {
        int[] arrs = {0,0,1,1,1,1,1,4};
        StaticSETofInts staticSETofInts = new StaticSETofInts(arrs);
        int count = staticSETofInts.howMany(1);
//        System.out.println(count);
        System.out.println(staticSETofInts.binaryFindLowest(1));
        System.out.println(staticSETofInts.binaryFindHighest(1));
        System.out.println(count);
    }

    public int howMany(int target) {
        int lo = 0;
        int hi = values.length - 1;
        if(binaryFindLowest(target) < 0) {
            return 0;
        }

        return binaryFindHighest(target) - binaryFindLowest(target) + 1;
    }

    public int binaryFindLowest(int target) {
        for(int lo = 0, hi = values.length-1; lo <= hi;) {
            int mid = (lo+hi)/2;
            if(values[mid] == target) {
                if(mid == 0 || values[mid - 1] != target) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            } else if(values[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public int binaryFindHighest(int target) {
        for(int lo = 0, hi = values.length-1; lo <= hi;) {
            int mid = (lo+hi)/2;
            if(values[mid] == target) {
                if(mid == values.length - 1 || values[mid+1] != target) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            } else if(values[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
