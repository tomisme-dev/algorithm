package com.chapter1.exercise;

import com.chapter1.da.Node;

public class Ex_1_3_20 {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(0);
        Node<Integer> tmp = root;
        for(int i = 1; i < 20; i++) {
            tmp.next = new Node(i);
            tmp = tmp.next;
        }
        System.out.println(root);
//        删除第一个元素
        System.out.println("===删除第0个元素");
        System.out.println(delete(root, 0));
        System.out.println(root);
        System.out.println("===删除最后1个元素");
        System.out.println(delete(root, 18));
        System.out.println(root);
        System.out.println("===删除第3个元素");
        System.out.println(delete(root, 3));
        System.out.println(root);
        System.out.println("===是否存在13");
        System.out.println(exist(root, 13));
        System.out.println("===是否存在520");
        System.out.println(exist(root, 520));
        System.out.println("===最大值");
        System.out.println(max(root));
        System.out.println("===递归求最大值");
        System.out.println(maxRecursive(root));
        System.out.println("===递归反转链接");
        System.out.println(root);
        root = reverse(root);
        System.out.println(root);
    }

    public static <E> E delete(Node<E> root, int k) {
        int i = 0;
        Node<E> prev = null;
        for (Node<E> n = root; n != null; n = n.next) {
            if(i == k) {
                if(i == 0) {
                    E result = n.item;
//                   要删除的元素在第一个位置
                    n.item = n.next.item;
                    n.next = n.next.next;
                    return result;
                } else if(n.next == null) {
//                    要删除的元素在最后个位置
                    E result = n.item;
                    prev.next = null;
                    return result;
                } else {
//                    在中间位置
                    prev.next = n.next;
                    return n.item;
                }
            }
            prev = n;
            i++;
        }

        throw new IndexOutOfBoundsException();
    }


    public static <E> boolean exist(Node<E> root, E item) {
        for(Node n = root; n != null; n = n.next) {
            if(n.item.equals(item)) {
                return true;
            }
        }

        return false;
    }


    public static int max(Node<Integer> root) {
        if(root == null) {
            return 0;
        }

        int max = root.item;
        for(Node<Integer> n = root; n != null; n = n.next) {
            if(n.item > max) {
                max = n.item;
            }
        }

        return max;
    }


    public static int maxRecursive(Node<Integer> root) {
        int max = root.item;
        if(root.next == null) {
            return max;
        }
        int nextItem = maxRecursive(root.next);
        return max > nextItem ? max : nextItem;
    }


    public static <E> Node<E> reverse(Node<E> root) {
        if(root.next == null) {
            return root;
        }

        Node<E> reverseRoot = reverse(root.next);
        root.next = null;
        for(Node<E> n = reverseRoot; n != null; n = n.next) {
            if(n.next == null) {
                n.next = root;
                break;
            }
        }
        return reverseRoot;
    }
}
