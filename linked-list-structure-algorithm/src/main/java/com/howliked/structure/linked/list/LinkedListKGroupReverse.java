package com.howliked.structure.linked.list;

/**
 * k个一组反转链表
 */
public class LinkedListKGroupReverse {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        System.out.println(KGroupReverse(head, 3));
    }

    private static ListNode KGroupReverse(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        ListNode temp = null;
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        for (int i = 0; i < length / k; i++) {
            for (int j = 1; j < k; j++) {
                temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
        }

        return dummyNode.next;
    }
}
