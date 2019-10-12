package com.chapter1.exercise;


import java.util.Iterator;

public class DequeImpl<E> implements Deque<E> {

    private static class Node<E> {
        public Node(E item) {
            this.item = item;
        }

        E item;
        Node<E> next;
        Node<E> prev;
    }

    private Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void pushLeft(E e) {
        Node<E> tmp = new Node<>(e);
        if(size == 0) {
            first = tmp;
            last = tmp;
        } else {
            tmp.next = first;
            first.prev = tmp;
            first = tmp;
        }
        size++;

    }

    @Override
    public void pushRight(E e) {
        Node<E> tmp = new Node<>(e);
        if(size == 0) {
            first = tmp;
            last = tmp;
        } else {
            last.next = tmp;
            tmp.prev = last;
            last = tmp;
        }
        size++;
    }

    @Override
    public E popLeft() {
        E result = first.item;
        if(size == 1) {
            first = null;
            last = null;
        } else {
            Node<E> newFirst = first.next;
            first.next = null;
            newFirst.prev = null;
            first = newFirst;

        }
        size--;
        return result;
    }

    @Override
    public E popRight() {
        E result = last.item;
        if(size == 1) {
            first = null;
            last = null;
        } else {
            Node<E> newLast = last.prev;
            last.prev = null;
            newLast.next = null;
            last = newLast;
        }
        size--;
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new DequeIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(E e: this) {
            sb.append(e + "-->");
        }
        return sb.toString();
    }

    private class DequeIterator implements Iterator<E> {
        private Node<E> cur = first;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public E next() {
            E result = cur.item;
            cur = cur.next;
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {
        Deque<Integer> dq = new DequeImpl<>();
        for(int i = 0; i < 10; i++) {
            dq.pushLeft(i);
        }
        System.out.println("pushLeft10次后");
        System.out.println(dq);

        System.out.println("pushRight10次后");
        for(int i = 10; i < 20; i++) {
            dq.pushRight(i);
        }
        System.out.println(dq);

        System.out.println("popRight5次后");
        for(int i = 0; i < 5; i++) {
            System.out.print(dq.popRight() + ",");
        }
        System.out.println();
        System.out.println(dq);

        System.out.println("popLeft5次后");
        for(int i = 0; i < 5; i++) {
            System.out.print(dq.popLeft() + ",");
        }
        System.out.println();
        System.out.println(dq);
    }
}
