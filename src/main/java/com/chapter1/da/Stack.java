package com.chapter1.da;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<E> implements Iterable<E> {

    private Node<E> last;
    private int size;

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


        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public E next() {
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

    public E pop() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        E result = last.val;
        last = last.prev;
        size--;
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
        }


    }
}
