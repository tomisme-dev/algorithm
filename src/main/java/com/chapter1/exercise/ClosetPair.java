package com.chapter1.exercise;

import com.chapter1.algo.DoubleGenerator;

import java.util.Arrays;

public class ClosetPair {
    private static class Pair {
        double val1;
        double val2;

        public Pair() {
        }

        public Pair(double val1, double val2) {
            this.val1 = val1;
            this.val2 = val2;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val1=" + val1 +
                    ", val2=" + val2 +
                    '}';
        }
    }


    public static Pair find(double[] inputs) {
        Arrays.sort(inputs);
        double minDistance = inputs[1] - inputs[0];
        Pair p = new Pair(inputs[1], inputs[0]);

        for(int i = 2; i < inputs.length; i++) {
            if(inputs[i] - inputs[i-1] < minDistance) {
                minDistance = inputs[i] - inputs[i-1];
                p.val1 = inputs[i];
                p.val2 = inputs[i-1];
            }
        }
        return  p;
    }

    public static void main(String[] args) {
        double[] inputs = DoubleGenerator.generate(5, 0, 30);
        Arrays.sort(inputs);
        System.out.println(Arrays.toString(inputs));
        Pair pair = find(inputs);
        System.out.println(pair);
    }
}
