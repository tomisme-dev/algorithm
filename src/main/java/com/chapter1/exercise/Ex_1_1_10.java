package com.chapter1.exercise;

public class Ex_1_1_10 {
    public static void main(String[] args) {
        boolean[][] arr = {{true, false}, {true, false}, {true, true}};
        print2DimensionArr(arr);
    }

    public static void print2DimensionArr(boolean[][] arr) {
//        打印列号
        System.out.printf(" ");
        for(int col = 0; col < arr[0].length; col++) {
            System.out.printf("%d", col);
        }
        System.out.println();

        for(int row = 0; row < arr.length; row++) {
//            打印行号
            System.out.printf("%d", row);
            for(int col = 0; col < arr[row].length; col++) {
                System.out.printf("%s", arr[row][col] ? "*": " ");
            }
            System.out.println();
        }
    }
}
