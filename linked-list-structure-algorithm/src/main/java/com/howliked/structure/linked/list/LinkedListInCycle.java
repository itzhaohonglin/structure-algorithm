package com.howliked.structure.linked.list;

/**
 * 寻找环的入口
 */
public class LinkedListInCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(inCycle(head));
    }

    private static int inCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head.val;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                slow = head;
                while (fast != slow) {
                    slow = slow.next;
                }
                return slow.val;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return -1;
    }
}
