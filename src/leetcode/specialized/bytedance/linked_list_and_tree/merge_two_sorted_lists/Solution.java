package leetcode.specialized.bytedance.linked_list_and_tree.merge_two_sorted_lists;

import leetcode.list.base.ListNode;

public class Solution {
    /*
     * 合并两个有序链表
     * link: https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1048/
     * Label: 链表
     *
     * 执行用时 : 1 ms
     * 内存消耗 : 39.3 MB
     * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode c = res;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                c.next = p1;
                c = c.next;
                p1 = p1.next;
            } else {
                c.next = p2;
                c = c.next;
                p2 = p2.next;
            }
        }
        if (p1 == null) {
            c.next = p2;
        } else {
            c.next = p1;
        }
        return res.next;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.mergeTwoLists(new ListNode(new int[]{1, 2, 4}), new ListNode(new int[]{1, 3, 4})));
        System.out.println(ss.mergeTwoLists(new ListNode(new int[]{1}), new ListNode(new int[]{1})));
        System.out.println(ss.mergeTwoLists(null, new ListNode(new int[]{1})));
        System.out.println(ss.mergeTwoLists(new ListNode(new int[]{1}), null));
        System.out.println(ss.mergeTwoLists(null, null));
    }
}
