package com.chapter1.da;

public interface IQueue<E> extends Iterable<E> {
    void enqueue(E e);
    boolean isEmpty();
    E dequeue();
    int size();
}
