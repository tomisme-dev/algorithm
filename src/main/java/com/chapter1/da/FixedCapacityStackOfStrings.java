package com.chapter1.da;

public class FixedCapacityStackOfStrings<E> {
    private int size;
    private E[] values;

    public FixedCapacityStackOfStrings(int cap) {
        values = (E[])new Object[cap];
    }

    public void push(E item) {
        values[size++] = item;
    }

    public E pop() {
        E result = values[size-1];
        values[size-1] = null;
        size--;
        return result;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings<String> stack = new FixedCapacityStackOfStrings(2);
        for (int i = 0; i < 100; i++) {
            stack.push(String.valueOf(i));
        }

        for(int i = 0, max = stack.size(); i < max; i++) {
            System.out.println(stack.pop());
        }
    }
}
