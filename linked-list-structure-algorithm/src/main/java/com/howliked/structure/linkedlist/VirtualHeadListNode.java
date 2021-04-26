package com.howliked.structure.linkedlist;

import com.howliked.structure.linkedlist.ListNode;

/**
 * 虚拟头节点
 * <p>
 * 第203题：移除链表元素
 * 题意：删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->3->6->4->5->6 val = 6
 * 输出: 1->2->3->4->5->6
 * 这里就涉及如下链表操作的两种方式：
 * 「直接使用原来的链表来进行删除操作。」
 * 「设置一个虚拟头结点在进行删除操作。」
 */
public class VirtualHeadListNode {

    public static void main(String[] args) {
        ListNode head = ListNode.getListNode();
        System.out.println(removeElement(head, 6));
    }

    private static ListNode removeElement(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        return head;
    }
}
