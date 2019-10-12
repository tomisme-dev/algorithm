package com.chapter1.exercise;

public interface IGeneralizedQueue<E> {
    boolean isEmpty();
    void insert(E e);
    E delete(int k);
}
