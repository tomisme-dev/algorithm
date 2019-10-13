package com.chapter1.exercise;

import java.util.ArrayList;
import java.util.List;

public class Ex_1_3_50 {
    public static void main(String[] args) {
        List<Integer> is = new ArrayList<>();
        is.add(1);
        is.add(1);
        for(int i: is) {
            is.add((int) (System.currentTimeMillis() % Integer.MAX_VALUE));
        }
    }
}
