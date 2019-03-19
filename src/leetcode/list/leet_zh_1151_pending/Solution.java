package leetcode.list.leet_zh_1151_pending;

public class Solution {
    public void deleteNode(ListNode node) {
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
        new Solution().deleteNode(listNode);
//        ListNode l = new Solution().deleteNode(listNode);
//        while (l != null) {
//            System.out.println(l.val);
//            l = l.next;
//        }
    }
}
