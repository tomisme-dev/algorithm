package com.chapter1.da;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<E> implements Iterable<E> {

    private Node<E> last;
    private int size;
    private volatile int modCount = 0;

    public Stack() {
        last = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator {
        private Node<E> cur = last;
        private volatile int expectedModifyCount = modCount;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public E next() {
            if(expectedModifyCount != modCount) {
                throw new ConcurrentModificationException();
            }

            if(!hasNext()) {
                throw new NoSuchElementException();
            }

            E result = cur.val;
            cur = cur.prev;

            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static class Node<E> {
        E val;
        Node prev;

        public Node(E val) {
            this.val = val;
        }
    }

    public void push(E e) {
        Node<E> n = new Node<>(e);
        if(isEmpty()) {
            last = n;
        } else {
            n.prev = last;
            last = n;
        }

        modCount++;
        size++;
    }

    public void reverse() {
        Node pre = null;
        while(last != null) {
            Node next = last.prev;
            last.prev = pre;
            pre = last;
            last = next;
        }
        last = pre;
    }

    public E peek() {
        return last.val;
    }

    public E pop() {
        E result = last.val;
        last = last.prev;
        size--;
        modCount++;
        return result;
    }

    boolean isEmpty() {
        return size < 1;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Stack<String> qs = new Stack<>();
        qs.push("1");
        qs.push("2");
        qs.push("3");
        qs.push("4");
        qs.push("5");

        for(int i = 0, maxSize = 2; i < maxSize ; i++) {
            System.out.println(qs.pop());
        }

        System.out.println("===========");
        for(String s: qs) {
            System.out.println(s);
        }

        System.out.println("===========");
        qs.reverse();
        for(String s: qs) {
            System.out.println(s);
            qs.push("b");
        }

        qs.push("b");


    }
}
