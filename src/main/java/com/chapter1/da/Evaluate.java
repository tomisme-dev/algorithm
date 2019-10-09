package com.chapter1.da;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Evaluate {

    public static Double calc(String express) {
        Stack<String> operators = new Stack<>();
        Stack<Double> vals = new Stack<>();

        Pattern compile = Pattern.compile("\\d+\\.?\\d*");
        Matcher matcher = compile.matcher(express);

        for (int i = 0; i < express.length(); i++) {
            char c = express.charAt(i);
            if(Character.isWhitespace(c)) {
                continue;
            }
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    operators.push(String.valueOf(c));
                    break;
                case ')':
                    String op = operators.pop();
                    double op1 = vals.pop();
                    double op2 = vals.pop();
                    switch (op) {
                        case "+":
                            op1 += op2;
                            break;
                        case "-":
                            op1 -= op2;
                            break;
                        case "*":
                            op1 *= op2;
                            break;
                        case "/":
                            op1 /= op2;
                            break;
                    }
                    vals.push(op1);
                    break;
            }

            if(Character.isDigit(c)) {
                matcher.find();
                String group = matcher.group();
                vals.push(Double.valueOf(group));
                i = i + group.length() - 1;
            }
        }


        return vals.pop();
    }

    public static void main(String[] args) {
        System.out.println("start");
        System.out.println(calc("(1+((2 * 30)*(4+5)))"));
    }
}
