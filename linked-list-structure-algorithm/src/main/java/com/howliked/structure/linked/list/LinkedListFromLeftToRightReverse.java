package com.howliked.structure.linked.list;

/**
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 示例1:
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 示例2:
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class LinkedListFromLeftToRightReverse {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(fromLeftToRightReverse(head, 2, 4));
    }

    private static ListNode fromLeftToRightReverse(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode temp = null;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        //头插法
        for (int i = 0; i < right - left; i++) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummyNode.next;
    }
}
