package leetcode.list.leet_zh_203;

import leetcode.list.base.ListNode;

public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        System.out.println("========");
        System.out.println(new Solution2().removeElements(head, 6));
    }
}