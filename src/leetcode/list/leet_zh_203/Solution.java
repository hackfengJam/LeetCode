package leetcode.list.leet_zh_203;

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
}