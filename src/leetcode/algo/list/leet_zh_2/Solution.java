package leetcode.algo.list.leet_zh_2;

import leetcode.algo.list.base.ListNode;

public class Solution {
    /*
     *
     * 2. 两数相加
     * 执行用时 : 10 ms, 在Add Two Numbers的Java提交中击败了92.72% 的用户
     * 内存消耗 : 45.1 MB, 在Add Two Numbers的Java提交中击败了81.36% 的用户
     *
     * 空间复杂度 O(1)，+1 直到末尾还需进位则考虑需要 new ListNode(carry)，节点
     * 时间复杂度 O(n)
     * 写的有些繁琐，待考虑是否可优化，先睡午觉去。
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        // 两个虚拟头结点
        ListNode dummyHead1 = new ListNode(-1);
        dummyHead1.next = l1;
        ListNode dummyHead2 = new ListNode(-1);
        dummyHead2.next = l2;

        // 进位
        int carry = 0;
        // 基值
        int base = 10;

        // 以下注释基于 demo: l1=[1,2,6] l2=[4,5,6,9]
        // l1=[1,2,6] l2=[4,5,6,9] -> l1=[5,7,2] carry=1
        while (dummyHead1.next != null) {
            dummyHead1 = dummyHead1.next;

            int val = carry + dummyHead1.val;

            if (dummyHead2.next != null) {
                dummyHead2 = dummyHead2.next;

                val += dummyHead2.val;
            }

            if (val >= base)
                carry = val / base;
            else
                carry = 0;
            val = val % base;
            dummyHead1.val = val;
        }

        // l1=[5,7,2] dummyHead1.next=[] dummyHead2.next=[9] carry=1 -> dummyHead1.next=[9] l1=[5,7,2,9] carry=1
        if (dummyHead2.next != null) {
            dummyHead1.next = dummyHead2.next;
        }

        //  dummyHead1.next=[9] l1=[5,7,2,9] carry=1 -> l1=[5,7,2,0,1] carry=0
        while (carry != 0) {
            if (dummyHead1.next == null) {
                dummyHead1.next = new ListNode(0);
            }
            while (dummyHead1.next != null) {
                dummyHead1 = dummyHead1.next;
                int val = carry + dummyHead1.val;
                if (val >= base)
                    carry = val / base;
                else
                    carry = 0;
                val = val % base;
                dummyHead1.val = val;
            }
        }


        return l1;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] arr = {7};
        int[] arr2 = {5};
//        int[] arr = {2, 4, 3};
//        int[] arr2 = {5, 6, 4};

        ListNode head = new ListNode(arr);
        ListNode head2 = new ListNode(arr2);

        System.out.println(ss.addTwoNumbers(head, head2));
    }
}
