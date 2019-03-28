package leetcode.list.leet_zh_203;

import leetcode.list.base.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return null;

        ListNode res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        System.out.println("========");
        System.out.println(new Solution().removeElements(head, 6));
    }
}