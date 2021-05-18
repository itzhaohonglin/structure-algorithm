package com.howliked.structure.linked.list;

/**
 * 删除链表重复的元素
 * 示例:1->1->1->2->3 返回 2->3
 * 示例:1->2->3-3->4->5-5 返回 1->2->4
 */
public class LinkedListDeleteDuplication {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        System.out.println(deleteDuplication(head));
    }

    private static ListNode deleteDuplication(ListNode head) {
        if (head == null) return null;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}
