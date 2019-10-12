package com.chapter1.exercise;

public interface Deque<E> extends Iterable<E> {
    boolean isEmpty();
    int size();
    void pushLeft(E e);
    void pushRight(E e);
    E popLeft();
    E popRight();
}
