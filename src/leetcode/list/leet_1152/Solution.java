package leetcode.list.leet_1152;


class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = head.next;
        ListNode cursor = evenNode.next;
        boolean flag = true;
        while (cursor != null) {
            if (flag) {
                oddNode.next = cursor;
                oddNode = oddNode.next;
                flag = !flag;
            } else {
                evenNode.next = cursor;
                evenNode = evenNode.next;
                flag = !flag;
            }
            cursor = cursor.next;
        }
        oddNode.next = evenHead;
        evenNode.next = null;

        // 1,2,3,4 -> 1,3,2,4
        // 1,2,3,4,5 -> 1,3,5,2,4
        // 1,2,3,4,5,6,7 -> 1,3,5,7,2,4,6

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