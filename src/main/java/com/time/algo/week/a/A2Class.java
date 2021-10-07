package com.time.algo.week.a;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2021/10/2 09:38
 */
public class A2Class {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode sentl = new ListNode();
        ListNode head = sentl;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;

        }
        if (l2 != null) {
            head.next = l2;
        }
        return sentl.next;

    }
}
