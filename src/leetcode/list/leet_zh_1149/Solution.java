package leetcode.list.leet_zh_1149;


import leetcode.list.base.ListNode;

public class Solution {


    public ListNode reverseList(ListNode head) {
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

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        ListNode l = new Solution().reverseList(listNode);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}