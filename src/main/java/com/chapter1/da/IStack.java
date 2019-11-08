package com.chapter1.da;

public interface IStack<E> extends Iterable<E> {
    boolean isEmpty();
    int size();
    E pop();
    E peek();
    void push(E e);
}
