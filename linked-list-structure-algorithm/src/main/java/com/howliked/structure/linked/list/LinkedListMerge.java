package com.howliked.structure.linked.list;

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

/**
 * 合并两个有序链表
 */
public class LinkedListMerge {
    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode node1 = new ListNode(3);
        t1.next = node1;

        ListNode t2 = new ListNode(2);
        ListNode t2Node1 = new ListNode(4);
        t2.next = t2Node1;
        System.out.println(mergeByIterate(t1, t2));
    }

    private static ListNode merge(ListNode t1, ListNode t2) {
        if (t1 == null) return t2;
        else if (t2 == null) return t1;
        else if (t1.val < t2.val) {
            t1.next = merge(t1.next, t2);
            return t1;
        } else {
            t2.next = merge(t1, t2.next);
            return t2;
        }
    }

    private static ListNode mergeByIterate(ListNode t1, ListNode t2) {
        if (t1 == null) return t2;
        else if (t2 == null) return t1;
        ListNode dummyNode = new ListNode(-1);
        ListNode pre = dummyNode;
        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                pre.next = t1;
                t1 = t1.next;
            } else {
                pre.next = t2;
                t2 = t2.next;
            }
            pre = pre.next;
        }
        pre.next = t1 == null ? t2 : t1;
        return dummyNode.next;
    }
}
