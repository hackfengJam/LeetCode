package leetcode.algo.list.leet_zh_25;

import leetcode.algo.list.base.ListNode;

public class Solution {
    /*
     * Title: 25. K 个一组翻转链表
     * Link : https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
     * Label: ["链表"]
     * Level: Hard
     * Desc :
     *
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
        k 是一个正整数，它的值小于或等于链表的长度。
        如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

        示例：
        给你这个链表：1->2->3->4->5
        当 k = 2 时，应当返回: 2->1->4->3->5
        当 k = 3 时，应当返回: 3->2->1->4->5

        说明：
        你的算法只能使用常数的额外空间。
        你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     * 执行用时 : 1 ms
     * 内存消耗 : 40.1 MB
     * */

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = null;

        int g = 0;
        ListNode cur = head;
        ListNode curHead = dummyHead;
        ListNode end = null;
        while (cur != null) {
            ListNode tmp = cur.next;

            if (g == 0) {
                end = cur;
            }
            cur.next = curHead.next;
            curHead.next = cur;

            g++;
            if (g == k) {
                curHead = end;
                g = 0;
            }

            cur = tmp;
        }
        if (g != 0) {
            cur = curHead.next;
            curHead.next = null;
            while (cur != null) {
                ListNode tmp = cur.next;

                cur.next = curHead.next;
                curHead.next = cur;

                cur = tmp;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.reverseKGroup(new ListNode(new int[]{1, 2, 3, 4, 5}), 2));
        System.out.println(ss.reverseKGroup(new ListNode(new int[]{1, 2, 3, 4, 5}), 3));
    }
}
