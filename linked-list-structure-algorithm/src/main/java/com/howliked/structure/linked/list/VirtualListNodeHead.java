package com.howliked.structure.linked.list;

public class VirtualListNodeHead {

    public static void main(String[] args) {
    }

    private static ListNode virtualHeadNode(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        return dummyNode.next;
    }
}
