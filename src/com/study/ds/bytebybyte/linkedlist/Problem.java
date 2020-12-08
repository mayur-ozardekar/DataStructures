package com.study.ds.bytebybyte.linkedlist;

/**
 * Given a singly linked list, write a function to find the nth-to-last element of the list.
 *
 * e.g.
 *
 * list = 1 -> 2 -> 3 -> 4 -> 5 -> null
 *
 * if k = 1 output = 4
 * if k = 2 output = 3
 * if k = 1 output = 2
 *
 */
public class Problem {

    private class Node {
        private int value;
        private Node next;
    }

    public static Node nthToLast_n(Node node, int n) {
        Node current = node;
        Node follower = node;

        for (int i = 0; i < n; i++) {
            if (current == null) throw new IllegalArgumentException();
            current = current.next;
        }

        while (current.next != null) {
            current = current.next;
            follower = follower.next;
        }

        return follower;
    }

}
