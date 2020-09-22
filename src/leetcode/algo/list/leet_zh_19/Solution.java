package leetcode.algo.list.leet_zh_19;

import leetcode.algo.list.base.ListNode;


public class Solution {
    /*
     * 执行用时 : 2 ms
     * 内存消耗 : 36.7 MB
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 采用双指针
        ListNode l = dummyHead;
        ListNode r = dummyHead; // l 表示待删除节点的前一个节点

        // 给定的 n 保证是有效的。
        for (int i = 0; i <= n; i++) {
            r = r.next;
        }
        while (r != null) {
            l = l.next;
            r = r.next;
        }
        ListNode delNode = l.next;
        l.next = delNode.next;
        delNode = null;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] arr = {1, 2, 3, 4, 5};
//        int[] arr = {1, 2};
        ListNode head = new ListNode(arr);
        System.out.println(ss.removeNthFromEnd(head, 2));
    }
}
