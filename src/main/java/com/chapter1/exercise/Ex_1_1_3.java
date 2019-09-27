package com.chapter1.exercise;

public class Ex_1_1_3 {
    public static void main(String[] args) {
        if(args == null || args.length != 3) {
            System.out.println("args number is illegal");
            return;
        }
        String val1 = args[0];
        boolean isEqual = true;
        for(int i = 1; i < 3; i++) {
            isEqual = isEqual && (val1.equals(args[i]));
        }

        if(isEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
}
