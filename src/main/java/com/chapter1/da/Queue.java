package com.chapter1.da;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements Iterable<E> {
    private Node first = null;
    private Node last = null;

    private int size = 0;


    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator<E> implements Iterator {
        Node<E> cur = first;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }

            E result =  cur.e;
            cur = cur.next;
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }



    public void enqueue(E e) {
        Node<E> node = new Node(e);
        if(first == null) {
            first = node;
            last = first;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public boolean isEmpty() {
        return size < 1;
    }

    public E dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> result = first;
        first = first.next;
        size--;
        return result.e;
    }

    public int size() {
        return size;
    }

    private static class Node<E> {
        private Node next;
        private E e;

        public Node(E element) {
            this.e = element;
        }

    }

    public static void main(String[] args) {
        Queue<String> qs = new Queue<>();
        qs.enqueue("1");
        qs.enqueue("2");
        qs.enqueue("3");
        qs.enqueue("4");
        qs.enqueue("5");

        for(int i = 0, maxSize = qs.size()-1; i < maxSize ; i++) {
            System.out.println(qs.dequeue());
        }

        System.out.println("===========");
        for(String s: qs) {
            System.out.println(s);
        }


    }
}
