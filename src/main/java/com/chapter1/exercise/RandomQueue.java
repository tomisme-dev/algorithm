package com.chapter1.exercise;

import com.chapter1.da.Queue;

import java.util.Random;

public class RandomQueue<E> extends Queue<E> {
    private static final Random random = new Random();

    public E sample() {
        int index = random.nextInt(size());
        int i = 0;
        for(E e: this) {
            if(i == index) {
                return e;
            }
            i++;
        }
        throw new AssertionError("不可能走到这里");
    }

    public static void main(String[] args) {
        RandomQueue<Integer> queue = new RandomQueue<>();
        for(int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        for(int i = 0; i < 20; i++) {
            System.out.println(queue.sample());
        }
    }
}
