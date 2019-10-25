package com.chapter1.exercise;

import com.chapter1.algo.IStopwatch;
import com.chapter1.algo.IntGenerator;
import com.chapter1.algo.Stopwatch;
import com.chapter1.algo.TimeCalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Ex_1_4_12 extends TimeCalc {

    @Override
    public double task(int size) {
        int[] inputs1 = IntGenerator.generate(size);
        int[] inputs2 = IntGenerator.generate(size);
        Arrays.sort(inputs1);
        Arrays.sort(inputs2);
        List<Integer> elements = new LinkedList<>();

        IStopwatch stopwatch = new Stopwatch();
        for(int i=0, j=0; i < size && j < size; ) {
            if(i < size-1 && inputs1[i] == inputs1[i+1]) {
                i++;
                continue;
            }

            if(j < size-1 && inputs2[j] == inputs2[j+1]) {
                j++;
                continue;
            }


            if(inputs1[i] == inputs2[j]) {
                elements.add(inputs1[i]);
                i++;
                j++;
            } else if(inputs1[i] < inputs2[j]) {
                i++;
            } else {
                j++;
            }
        }

        System.out.println("inputs1:" + Arrays.toString(inputs1));
        System.out.println("inputs2:" + Arrays.toString(inputs2));
        System.out.println("elements:" + elements);

        double time = stopwatch.elapsedTime();
        System.out.println(time);
        return 12L;
    }

    public static void main(String[] args) {
        Ex_1_4_12 ex_1_4_12 = new Ex_1_4_12();
        ex_1_4_12.task(20);
    }
}
