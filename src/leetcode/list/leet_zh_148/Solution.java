package leetcode.list.leet_zh_148;

import leetcode.list.base.ListNode;


public class Solution {
    /*
     *
     * 148. 排序链表
     *
     * 16 / 16 个通过测试用例
     * 执行用时：922 ms
     *
     * 执行用时 : 922 ms, 在Sort List的Java提交中击败了6.22% 的用户
     * 内存消耗 : 44.3 MB, 在Sort List的Java提交中击败了60.95% 的用户
     * */
    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;
        return partition(head, null);
    }

    private ListNode partition(ListNode start, ListNode end) {
        if (start == null) return null;
        if (start == end) return start;

        ListNode des = start;
        ListNode head = des;

        ListNode pre = start;
        ListNode cur = start.next;
        while (cur != end && cur != null) {
            if (cur.val <= des.val) {
                pre.next = cur.next; // del cur
                cur.next = head; // insert before head
                head = cur; // head
                cur = pre.next; // next cur
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        des.next = partition(des.next, cur);
        head = partition(head, des);

        return head;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] arr = {4, 2, 1, 3, 1, 2, 2, 3, 1, 1, 10, 2, 9, 5, 7};
        ListNode head = new ListNode(arr);
        System.out.println(ss.sortList(head));
    }
}
