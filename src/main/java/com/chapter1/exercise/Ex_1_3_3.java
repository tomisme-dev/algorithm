package com.chapter1.exercise;

import com.chapter1.da.Stack;

import java.util.*;

public class Ex_1_3_3 {
    static Map<Character, Character> map = new HashMap<>();
    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public static void main(String[] args) {
        String parentheses = "[()]{}{[()()]()}";
        System.out.println(isParenthese(parentheses));
        System.out.println(isParenthese("[(])"));
    }

    public static boolean isParenthese(String par) {
        Stack<Character> stack = new Stack<>();
        for(char c: par.toCharArray()) {
            if(map.values().contains(c)) {
                stack.push(c);
            } else {
                Character cFromMap = stack.pop();
                if(!map.get(c).equals(cFromMap)) {
                    return false;
                }
            }
        }

        return true;
    }
}
