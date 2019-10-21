package com.chapter1.exercise;

import com.chapter1.algo.IntGenerator;

import java.util.Arrays;

public class ThreeSumFaster {
    public static int sumZeroCount(int[] inputs) {
        int first = 0;
        int last = inputs.length - 1;
        int count = 0;
        for(int i = 0; i < inputs.length; i++) {
            for(first = i + 1, last = inputs.length - 1; first <= last; ) {
                if(inputs[first] + inputs[last] == -inputs[i]) {
                    count++;
                    System.out.printf("%d, %d, %d == %d, %d, %d\n", i, first, last, inputs[i], inputs[first], inputs[last]);
                    first++;
                    last--;
                    continue;
                } else if(inputs[first] + inputs[last] > -inputs[i]) {
                    last--;
                } else {
                    first++;
                }
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
