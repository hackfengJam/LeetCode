package leetcode.list.leet_zh_237;

import leetcode.list.base.ListNode;

public class Solution {
    /*
     * 执行用时 : 0 ms
     * 内存消耗 : 37.8 MB
     * */
    public void deleteNode(ListNode node) {
        // 至少包含两个节点
//        if (node == null || node.next == null)
//            return;
//        else {
        node.val = node.next.val;
        node.next = node.next.next;
//        }
    }
}