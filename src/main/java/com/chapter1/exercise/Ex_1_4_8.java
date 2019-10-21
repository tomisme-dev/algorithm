package com.chapter1.exercise;

import com.chapter1.algo.IStopwatch;
import com.chapter1.algo.IntGenerator;
import com.chapter1.algo.Stopwatch;
import com.chapter1.algo.TimeCalc;

public class Ex_1_4_8 extends TimeCalc {
    public static void main(String[] args) {
        Ex_1_4_8 timeTest = new Ex_1_4_8();
        timeTest.start();
    }

    static int equalPairCount(int[] intputs) {
        int count = 0;
        for(int i = 0; i < intputs.length; i++) {
            for(int j = i + 1; j < intputs.length; j++) {
                if(intputs[i] == intputs[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    @Override
    public double task(int size) {
        int[] inputs = IntGenerator.generate(size);
        IStopwatch iStopwatch = new Stopwatch();
        equalPairCount(inputs);
        return iStopwatch.elapsedTime();
    }
}
