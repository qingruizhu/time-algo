package com.time.algo.week03.student;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class S1 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        // 小顶堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode n1, ListNode n2) {
                        return n1.val - n2.val;
                    }
                }
        );
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode head = new ListNode();
        ListNode curt = head;
        while (queue.size() > 0) {
            ListNode tmp = queue.poll();
            curt.next = tmp;
            curt = curt.next;
            if (tmp.next != null) {
                queue.add(tmp.next);
            }

        }
        return head.next;
    }


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
}
