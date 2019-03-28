package leetcode.list.leet_zh_160;

import leetcode.list.base.ListNode;

public class Solution3 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode last = headB;
        while (last.next != null) {
            last = last.next;
        }
        last.next = headB;

        ListNode fast = headA;
        ListNode slow = headA;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = headA;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                last.next = null;
                return fast;
            }
        }
        last.next = null;
        return null;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 1};
        int[] arr2 = {5, 0, 1};
        ListNode headA = new ListNode(arr1);
        ListNode headB = new ListNode(arr2);

        int[] arr3 = {8, 4, 5};
        ListNode tailAB = new ListNode(arr3);

        headA.next = tailAB;
        headB.next = tailAB;


        Solution3 ss = new Solution3();
        System.out.println(ss.getIntersectionNode(headA, headB).val);

    }
}