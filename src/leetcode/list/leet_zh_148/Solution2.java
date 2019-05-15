package leetcode.list.leet_zh_148;

import leetcode.list.base.ListNode;


public class Solution2 {
    /*
     *
     * 148. 排序链表
     *
     *
     * 16 / 16 个通过测试用例
     * 执行用时：13 ms
     *
     * 执行用时 : 13 ms, 在Sort List的Java提交中击败了30.03% 的用户
     * 内存消耗 : 45.1 MB, 在Sort List的Java提交中击败了40.57% 的用户
     * */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // step 1. cut the list to tow halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);

    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummyHead = new ListNode(-1), p = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        } else
            p.next = l2;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution2 ss = new Solution2();
        int[] arr = {2, 2, 3, 1, 1, 10, 2, 9, 5, 7};
        ListNode head = new ListNode(arr);
        System.out.println(ss.sortList(head));
    }
}
