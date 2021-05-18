package com.howliked.structure.linked.list;

public class RevenseLinkList {
    public static ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        ListNode res = new ListNode(0);
        res.next=head;
        ListNode pre = res;
        ListNode cur = head;
        ListNode temp = null;
        //先求出链表的长度
        int length=0;
        while(null != head){
            length ++;
            head = head.next;
        }
        //将链表进行分段，分段之后再反转
        //外循环控制分段，内循环控制反转
        int group = 0;
        if(length % k == 0){
            group = length/k;
        }else {
            group = length/k+1;
        }
        for(int i=0;i<group;i++){
            for(int j=1;j<k;j++){
                if(null !=cur.next){
                    temp = cur.next;
                    cur.next =temp.next;
                    temp.next=pre.next;
                    pre.next=temp;
                }
            }
            pre = cur;
            cur = cur.next;
        }
        return res.next;
    }

    public static void main(String []args){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode listNode = reverseKGroup(head,3);
        System.out.println(listNode);
    }
}
