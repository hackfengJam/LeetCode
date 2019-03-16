package leetcode.list.zh_1150;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(-1);
        res.next = null;
        ListNode preNode = head;
        ListNode endNode = null;
        while (preNode != null) {
            endNode = preNode.next;
            preNode.next = res.next;
            res.next = preNode;
            preNode = endNode;
        }
        return res.next;
    }


    public boolean isPalindrome(ListNode head) {
        int cnt = 0;
        ListNode cursor = head;
        while (cursor != null) {
            cnt++;
            cursor = cursor.next;
        }

        int i = 0;
        ListNode midNode = head;
        while (midNode != null) {
            if (i == cnt / 2) {
                break;
            }
            i++;

            midNode = midNode.next;
        }
        midNode = reverseList(midNode);

        boolean isPalindrome = true;
        while (midNode != null) {
            if (midNode.val != head.val) {
                isPalindrome = false;
                break;
            } else {
                midNode = midNode.next;
                head = head.next;
            }
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(1);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        boolean isP = new Solution().isPalindrome(listNode);
        System.out.println(isP);
    }
}