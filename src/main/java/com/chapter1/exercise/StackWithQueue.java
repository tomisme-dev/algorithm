package com.chapter1.exercise;

import com.chapter1.da.IQueue;
import com.chapter1.da.IStack;
import com.chapter1.da.Queue;

import java.util.Iterator;

public class StackWithQueue<E> implements IStack<E> {
    IQueue<E> queue = new Queue<>();

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public E pop() {
        pushLastedToDeep();
        return queue.dequeue();
    }

    @Override
    public E peek() {
        E element = pop();
        queue.enqueue(element);
        return element;
    }

    private void pushLastedToDeep() {
        int size = size();
        for(int i = 0; i < size-1; i++) {
            E element = queue.dequeue();
            queue.enqueue(element);
        }
    }

    @Override
    public void push(E e) {
        queue.enqueue(e);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public static void main(String[] args) {
        IStack<Integer> stack = new StackWithQueue<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(1);
        stack.push(5);
        System.out.println("peek>>" +  stack.peek());
        for(int i = 0; i < 3; i++) {
            System.out.println(stack.pop());
        }

        stack.push(9);
        stack.push(2);
        stack.push(6);

        for(int i = 0, max=stack.size(); i < max; i++) {
            System.out.println(stack.pop());
        }
    }
}
