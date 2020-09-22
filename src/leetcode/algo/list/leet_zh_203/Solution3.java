package leetcode.algo.list.leet_zh_203;

import leetcode.algo.list.base.ListNode;

public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return null;

        ListNode res = removeElements(head.next, val);


        // 其实性能并非很好，但代码简洁
        head.next = res;
        return head.val == val ? res : head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        System.out.println("========");
        System.out.println(new Solution3().removeElements(head, 6));
    }
}