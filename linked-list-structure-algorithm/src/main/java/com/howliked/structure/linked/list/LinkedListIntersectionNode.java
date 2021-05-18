package com.howliked.structure.linked.list;

/**
 * getIntersectionNode
 */
public class LinkedListIntersectionNode {
    public static void main(String[] args) {

    }

    private static ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        int lenA = 0, lenB = 0;
        ListNode curA = l1;
        ListNode curB = l2;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }
        curA = l1;
        curB = l2;
        if (lenB > lenA) {
            //1.长度交换
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            //2.链表交换
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        //求长度差
        int gap = lenA - lenB;
        while (gap-- > 0) {
            curA = curA.next;
        }
        //遍历curA 和 curB，遇到则返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
