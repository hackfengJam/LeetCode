package leetcode.list.leet_zh_160;

import leetcode.list.base.ListNode;

import java.util.Stack;

public class Solution {
    /*
     * 160. Intersection of Two Linked Lists
     * 执行用时 : 17 ms
     * 内存消耗 : 46.8 MB
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }
        int ln = stackA.size() > stackB.size() ? stackB.size() : stackA.size();
        ListNode res = null;
        for (int i = 0; i < ln; i++) {
            headA = stackA.pop();
            headB = stackB.pop();
            if (headA == headB) {
                res = headA;
            }
        }
        return res;
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


        Solution ss = new Solution();
        System.out.println(ss.getIntersectionNode(headA, headB).val);

    }
}