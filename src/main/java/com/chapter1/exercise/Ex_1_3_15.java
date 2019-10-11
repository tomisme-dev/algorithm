package com.chapter1.exercise;

import com.chapter1.da.Queue;

public class Ex_1_3_15 {
    public static void main(String[] args) {
        int k = 2;
        String[] inputString = {"a", "b", "c", "d", "f"};
        Queue<String> q = new Queue<>();
        for (String s: inputString) {
            q.enqueue(s);
        }

        for(String s: q) {
            System.out.println(s);
        }

        int index = inputString.length - k;
        int i = 0;
        for(String s: q) {
            if(i == index) {
                System.out.println("====" + s);
            }
            i++;
        }
    }
}
