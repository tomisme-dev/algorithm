package com.chapter1.exercise;

import com.chapter1.da.IQueue;
import com.chapter1.da.Queue;

import java.util.Iterator;

public class CircularQueue<E> implements IQueue<E> {
    private Node<E> last;
    private int size;


    @Override
    public void enqueue(E e) {
        Node<E> tmp = new Node<E>(e);
        if(size == 0) {
            last = tmp;
            last.next = last;
        } else {
            tmp.next = last;
            for(Node<E> n = last; n != null; n = n.next) {
                if(n.next == last) {
                    n.next = tmp;
                    last = tmp;
                    break;
                }
            }
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public E dequeue() {
        E result = null;
        if(size == 1) {
            result = last.item;
            last = null;
            return result;
        }
        for(Node<E> n = last; n != null; n = n.next) {
            if(n.next.next == last) {
                result = n.next.item;
                n.next = last;
                break;
            }
        }
        size--;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        IQueue<Integer> q = new CircularQueue<>();
        int n = 12;
        for(int i = 0; i < n; i++) {
            q.enqueue(i);
        }

        for(int i = 0; i < n; i++) {
            System.out.println(q.dequeue());
        }

    }
}
