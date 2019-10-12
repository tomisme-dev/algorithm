package com.chapter1.exercise;

import com.chapter1.da.Node;

public class Ex_1_3_31 {
    private static class DoubleNode <E> {
        E item;
        DoubleNode<E> prev;
        DoubleNode<E> next;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(DoubleNode n = this; n != null; n = n.next) {
                sb.append(String.format("[%s]-->", n.item));
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        DoubleNode<Integer> root = genDoubleNode();
        System.out.println("===构建双向链接");
        System.out.println(root);
        System.out.println("===首位插入");
        root = insertFirst(root, -1);
        System.out.println(root);
        System.out.println("===末位插入");
        appendLast(root, 520);
        System.out.println(root);
        System.out.println("===在第3号前插入");
        insertBefore(root, 88, 3);
        System.out.println(root);
    }

    public static <E> DoubleNode<E> insertFirst(DoubleNode<E> root, E item) {
        DoubleNode<E> result = new DoubleNode<>();
        result.item = item;
        result.next = root;
        root.prev = result;
        return result;
    }

    public static <E> DoubleNode<E> insertBefore(DoubleNode<E> root, E item, int index) {
        int i = 0;
        DoubleNode<E> result = new DoubleNode<>();
        result.item = item;
        for (DoubleNode<E> n = root; n != null; n = n.next) {
            if(i==index && i==0) {
                result.next = root;
                root.prev = result;
                return result;
            } else if(i == index) {
                result.next = n;
                DoubleNode<E> prev = n.prev;
                prev.next = result;
                result.prev = prev;
                n.prev = result;
                return root;
            }

            i++;
        }

        throw new IndexOutOfBoundsException();
    }

    public static <E> DoubleNode<E> appendLast(DoubleNode<E> root, E item) {
        DoubleNode<E> addNode = new DoubleNode<>();
        addNode.item = item;
        for(DoubleNode<E> node = root; node != null; node = node.next) {
            if(node.next == null) {
                node.next = addNode;
                addNode.prev = node;
                break;
            }
        }
        return root;
    }

    public static DoubleNode<Integer> genDoubleNode() {
        DoubleNode<Integer> root = new DoubleNode<>();
        root.item = 0;

        DoubleNode<Integer> prev = root;
        for(int i = 1; i < 15; i++) {
            DoubleNode tmp = new DoubleNode<>();
            tmp.item = i;
            tmp.prev = prev;
            prev.next = tmp;
            prev = tmp;
        }

        return root;
    }


}
