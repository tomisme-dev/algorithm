package com.chapter1.exercise;

import java.util.Objects;

public class MoveToFront<E> {
    private static class Node<E> {
        E item;
        Node<E> next;
    }

    private Node<E> first;
    private int size;

    public void add(E e) {
        boolean isDup = false;
        Node<E> prev = null;
        for(Node<E> n = first; n != null; n = n.next) {
            if(Objects.equals(n.item, e)) {
//                删除相同的node
                if(prev == null) {
                    first = null;
                } else {
                    prev.next = n.next;
                }
                size--;
                break;
            }
            prev = n;
        }

//        在头部插入
        insertFront(e);
    }

    private void insertFront(E e) {
        Node<E> tmp = new Node<>();
        tmp.item = e;
        if(size == 0) {
            first = tmp;
        } else {
            tmp.next = first;
            first = tmp;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Node<E> node = first; node != null; node = node.next) {
            sb.append(node.item + "-->");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MoveToFront<Integer> list = new MoveToFront<Integer>();
        for(int i = 0 ; i < 10; i++) {
            list.add(1);
        }
        System.out.println("十次添加后====");
        System.out.println(list);
        for(int i = 0 ; i < 10; i++) {
            list.add(i);
        }
        System.out.println("添加1-10后====");
        System.out.println(list);
        for(int i = 0 ; i < 10; i++) {
            System.out.println("添加" + i + "后====");
            list.add(i);
            System.out.println(list);
        }

    }
}
