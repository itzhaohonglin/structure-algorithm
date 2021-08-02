package com.howliked.structure.linked.list;

public class DoubleNodeReverse {
    public static void main(String[] args) {
        DoubleNode node = new DoubleNode(5);
        DoubleNode node1 = new DoubleNode(6);
        DoubleNode node2 = new DoubleNode(7);
        DoubleNode node3 = new DoubleNode(8);
        DoubleNode node4 = new DoubleNode(9);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.last = node;
        node2.last = node1;
        node3.last = node2;
        node4.last = node3;
        System.out.println("===========node===========");
        System.out.println(reverseDoubleList(node));
    }

    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        while (head != null) {
            DoubleNode temp = head.next;
            head.next = pre;
            head.last = temp;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
