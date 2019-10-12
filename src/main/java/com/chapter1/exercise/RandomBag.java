package com.chapter1.exercise;

import com.chapter1.da.Bag;

import java.util.Iterator;
import java.util.Random;

public class RandomBag<E> implements Bag<E> {
    public static Random random = new Random();

    public static final int DEFAULT_SIZE = 16;
    private E[] values;
    int size;

    public RandomBag() {
        this.values = (E[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        size++;
        ensureCapacity();
        values[size-1] = e;
    }

    private void ensureCapacity() {
        if(size > values.length) {
            int newSize = values.length + (values.length >> 1);
            E[] newValues = (E[]) new Object[newSize];
            System.arraycopy(values, 0, newValues, 0, values.length);
            values = newValues;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new BagIterator();
    }


    private static void shuffle(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int changeIndex = i + random.nextInt(arr.length - i);
            int tmp = arr[changeIndex];
            arr[changeIndex] = arr[i];
            arr[i] = tmp;
        }
    }

    private class BagIterator implements Iterator<E> {
        private int curIndex = 0;
        private int[] indexs = new int[size];

        public BagIterator() {
            for(int i = 0; i < size; i++) {
                indexs[i] = i;
            }

            shuffle(indexs);
        }

        @Override
        public boolean hasNext() {
            return curIndex < size;
        }

        @Override
        public E next() {
            E result = values[indexs[curIndex]];
            curIndex++;
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomBag<Integer> randomBag = new RandomBag<>();
        for(int i = 0; i < 20; i++) {
            randomBag.add(i);
        }

        System.out.println("第一次");
        for(Integer i: randomBag) {
            System.out.print(i + "-->");
        }
        System.out.println();

        System.out.println("第二次");
        for(Integer i: randomBag) {
            System.out.print(i + "-->");
        }
    }
}
