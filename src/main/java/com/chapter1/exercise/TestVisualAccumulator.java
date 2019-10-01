package com.chapter1.exercise;

import com.chapter1.da.VisualAccumulator;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestVisualAccumulator {
    public static void main(String[] args) {
        int n = 10000;
        VisualAccumulator visualAccumulator = new VisualAccumulator(n, 1);
        for(int i = 0; i < n; i++) {
            visualAccumulator.addDataValue(StdRandom.random());
        }
        System.out.println(visualAccumulator);

    }
}
