package com.chapter1.exercise;

import java.util.Arrays;

public class ArrayGeneralizedQueue<E> implements IGeneralizedQueue<E> {
    private E[] values;
    private static final int DEFAULT_SIZE = 16;
    private int size;

    public ArrayGeneralizedQueue() {
        values = (E[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public void insert(E e) {
        size++;
        ensureCapacity();
        values[size-1] = e;
    }

    private void ensureCapacity() {
        if(size > values.length) {
            int newSize = values.length + (values.length >> 1);
            E[] tmp = (E[])new Object[newSize];
            System.arraycopy(values, 0, tmp, 0, values.length);
            values = tmp;
        }


    }

    @Override
    public E delete(int k) {
        for(int i = k; i < size-1; i++) {
            values[i] = values[i+1];
        }
        values[size-1] = null;
        size--;
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

    public static void main(String[] args) {
        IGeneralizedQueue queue = new ArrayGeneralizedQueue<>();
        for(int i = 0 ; i < 20; i++) {
            queue.insert(i);
        }
        System.out.println(queue);
        System.out.println("删除第3个");
        System.out.println(queue.delete(3));
        System.out.println(queue);
    }
}
