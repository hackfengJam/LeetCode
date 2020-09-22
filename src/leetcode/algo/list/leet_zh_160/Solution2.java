package leetcode.algo.list.leet_zh_160;

import leetcode.algo.list.base.ListNode;

public class Solution2 {
    /*
     * 160. Intersection of Two Linked Lists
     * 执行用时 : 2 ms
     * 内存消耗 : 46.9 MB
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        if (headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
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


        Solution2 ss = new Solution2();
        System.out.println(ss.getIntersectionNode(headA, headB).val);

    }
}