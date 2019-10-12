package com.chapter1.da;

public interface Bag<E> extends Iterable<E> {
    boolean isEmpty();
    int size();
    void add(E e);
}
