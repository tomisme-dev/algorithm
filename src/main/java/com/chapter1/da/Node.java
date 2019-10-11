package com.chapter1.da;

public class Node<E> {
    public E item;
    public Node<E> next;

    public Node(E item) {
        this.item = item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Node n = this; n != null; n = n.next) {
            sb.append(String.format("[%s]-->", n.item));
        }
        return sb.toString();
    }
}
