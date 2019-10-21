package com.chapter1.exercise;

import com.chapter1.algo.IntGenerator;

import java.util.Arrays;

public class TwoSumFaster {

    public static int sumZeroCount(int[] inputs) {
        int first = 0;
        int last = inputs.length - 1;
        int count = 0;
        for(; first <= last; ) {
            if(inputs[first] + inputs[last] == 0) {
                count++;
                first++;
                last--;
                continue;
            } else if(inputs[first] + inputs[last] > 0) {
                last--;
            } else {
                first++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] inputs = IntGenerator.generate(15, -10, 10);
        Arrays.sort(inputs);
        System.out.println(Arrays.toString(inputs));
        System.out.println(sumZeroCount(inputs));
    }
}
