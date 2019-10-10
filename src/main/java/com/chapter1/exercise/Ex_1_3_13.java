package com.chapter1.exercise;

import com.chapter1.da.Stack;

public class Ex_1_3_13 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        for(String s : stack) {
            System.out.println(s);
        }
        System.out.println("===");
        Stack<String> copy = copy(stack);
        for(String s : copy) {
            System.out.println(s);
        }
    }

    public static Stack<String> copy(Stack<String> raw) {
        Stack<String> tmp = new Stack<>();
        for(String ele: raw) {
            tmp.push(ele);
        }

        Stack<String> result = new Stack<>();
        for(String ele: tmp) {
            result.push(ele);
        }

        return result;
    }
}
