package com.chapter1.da;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<E> implements Iterable<E> {
    private static final int DEFAULT_CAP = 16;
    private int size;
    private E[] values;

    public ResizingArrayStack(int cap) {
        int len = cap > DEFAULT_CAP ? cap : DEFAULT_CAP;
        values = (E[])new Object[len];
    }

    public void push(E item) {
        if(size >= values.length) {
            resize(size + (size >> 1));
        }
        values[size++] = item;
    }

    private void resize(int max) {
        E[] temp = (E[])new Object[max];
        for(int i = 0; i < size; i++) {
            temp[i] = values[i];
        }
        values = temp;
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
        ResizingArrayStack<String> stack = new ResizingArrayStack<>(2);
        for (int i = 0; i < 100; i++) {
            stack.push(String.valueOf(i));
        }

        for(String s: stack) {
            System.out.println(s);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<E> {
        int cur = size-1;

        @Override
        public boolean hasNext() {
            return cur >= 0;
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }

            return values[cur--];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
