package leetcode.list.leet_zh_1152;


import leetcode.list.base.ListNode;

class Solution {
    /*
     * 328.奇偶链表
     * 执行用时 : 6 ms
     * 内存消耗 : 39.1 MB
     * */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = evenNode;

        ListNode cursor = evenNode.next;
        while (oddNode.next != null && evenNode.next != null) {
            oddNode.next = cursor;
            oddNode = oddNode.next;
            cursor = cursor.next;

            evenNode.next = cursor;
            evenNode = evenNode.next;
            cursor = cursor.next;
        }
        if (cursor != null) {
            oddNode.next = cursor;
            oddNode = oddNode.next;
        }

        oddNode.next = evenHead;
        evenNode.next = null;

        return head;
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
        ListNode l = new Solution().oddEvenList(listNode);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}