package com.chapter1.exercise;

public class Ex_1_2_6 {
    public static void main(String[] args) {
        String s1 = "ACTGACG";
        String s2 = "TGACGAC";
        System.out.println(isCircularRotation(s1, s2));
    }
    public static boolean isCircularRotation(String str1, String str2) {
        for(int i = 0; i < str2.length(); i++) {
            String s = str2.substring(i) + str2.substring(0, i);
            if(s.equals(str1)) {
                return true;
            }
        }
        return false;
    }
}
