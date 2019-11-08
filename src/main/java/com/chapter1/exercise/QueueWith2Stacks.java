package com.chapter1.exercise;

import com.chapter1.da.IQueue;
import com.chapter1.da.IStack;
import com.chapter1.da.Stack;

import java.util.Iterator;

public class QueueWith2Stacks<E> implements IQueue<E> {
    private IStack<E> stack = new Stack<>();
    private IStack<E> emptyStack = new Stack<>();
    private boolean lastEleInTop = true;

    @Override
    public void enqueue(E e) {
        if(!lastEleInTop) {
            //            最旧的在最上面
            //            调整一下, 确保最新的在上面
            exchangeStackAndEmptyStack();
            lastEleInTop = true;
        }

        stack.push(e);
    }

//    将stack中的数据调整到emptyStack中
    private void exchangeStackAndEmptyStack() {
        while (stack.size() > 0) {
            E element = stack.pop();
            emptyStack.push(element);
        }
        IStack<E> tmp = stack;
        stack = emptyStack;
        emptyStack = tmp;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public E dequeue() {
        if(lastEleInTop) {
//            如果新的在最上面,则调整一下
            exchangeStackAndEmptyStack();
            lastEleInTop = false;
        }
        return stack.pop();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public static void main(String[] args) {
        IQueue<Integer> queue = new QueueWith2Stacks<>();
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(4);
        queue.enqueue(1);
        queue.enqueue(5);
        queue.size();
        for(int i = 0, max = queue.size()/2; i < max; i++) {
            System.out.println(queue.dequeue());
        }

        queue.enqueue(9);
        queue.enqueue(2);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(9);

        System.out.println("----------------------------------");
        for(int i = 0, max = queue.size(); i < max; i++) {
            System.out.println(queue.dequeue());
        }

    }
}
