package com.howliked.structure.linked.list;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例1:
 * 输入:head=[1,2,3,4]
 * 输出:head=[2,1,4,3]
 * <p>
 * 示例2:
 * 输入:head=[]
 * 输出:head=[]
 * <p>
 * 示例3:
 * * 输入:head=[1]
 * * 输出:head=[1]
 */
public class LinkedListSwapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        System.out.println(swapPairs(head));
    }

    private static ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null && cur.next.next != null) {
            // -1->1-2->3->4
            ListNode tmp1 = cur.next;
            ListNode tmp2 = cur.next.next.next;

            //[0]==[1]  -> -1->2-2->3->4
            cur.next = cur.next.next;    // 步骤一
            //[1]==[0]  -> -1->2-1->3->4
            cur.next.next = tmp1;          // 步骤二
            //[2]==[2]  -> -1->2-1->3->4
            cur.next.next.next = tmp2;   // 步骤三

            cur = cur.next.next; // cur移动两位，准备下一轮交换
        }
        return dummyNode.next;
    }
}
