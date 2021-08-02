package com.howliked.structure.linked.list;

/**
 * 双向链表
 */
public class DoubleNode {
    public int value;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode(int data) {
        value = data;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
