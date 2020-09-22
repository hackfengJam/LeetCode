package leetcode.algo.list.leet_zh_141;

import leetcode.algo.list.base.ListNode;

public class Solution {
    /*
     * 141. 环形链表
     *
     *
     * 执行用时 : 0 ms, 在Linked List Cycle的Java提交中击败了100.00% 的用户
     * 内存消耗 : 36.2 MB, 在Linked List Cycle的Java提交中击败了97.31% 的用户
     *
     * */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        return (fast != null && fast.next != null);
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
//        int[] arr = {2, 2, 3, 1, 1, 10, 2, 9, 5, 7};
        int[] arr = {2, 2};
        ListNode head = new ListNode(arr);
        head.next.next = head;
        System.out.println(ss.hasCycle(head));
    }
}
