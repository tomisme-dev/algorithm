package com.chapter1.exercise;


import java.util.ArrayList;
import java.util.List;

public class Ex_1_3_37 {

    private static class Node<E> {
        E item;
        Node<E> next;
        int index;


        public Node(E item) {
            this.item = item;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(Node<E> n = this; n != null; n = n.next) {
                sb.append(String.format("[%s]-->", n.item));
            }
            return sb.toString();
        }
    }


    public static void main(String[] args) {
        int size = 26;
        Node<Integer> root = new Node<>(0);
        root.index = 0;

        Node<Integer> prev = root;
        for(int i = 1; i < size; i++) {
            Node<Integer> tmp = new Node<>(i);
            tmp.index = i;
            prev.next = tmp;
            if(i == size - 1) {
                tmp.next = root;
            }
            prev = tmp;
        }

        int n = 3;
        List<Integer> reduce = reduce(root, size, n);
        System.out.println(reduce);
    }

    private static List<Integer> reduce(Node<Integer> root, int size, int n) {
        List<Integer> indexs = new ArrayList<>();
        Node<Integer> prev = null;
        for(Node<Integer> node = root; node != null; node = node.next) {
            if(node.next == root) {
                prev = node;
                break;
            }
        }

        int i = 1;
        while(size > 1) {
            if(i % n == 0) {
                indexs.add(root.index);
                prev.next = root.next;
                size--;
            }
            i++;
            prev = root;
            root = root.next;
        }

        return indexs;
    }
}
