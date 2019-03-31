package weekly_contest.th_130.leet_zh_1030;

import weekly_contest.th_130.base.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    /*
     * 1030. 链表中的下一个更大节点
     * */

//    /*
//    * 执行用时 : 630 ms
//    * */
//    public int[] nextLargerNodes(ListNode head) {
//        List<Integer> nums = new ArrayList<>();
//        while (head != null) {
//            nums.add(head.val);
//            head = head.next;
//        }
//        int[] res = new int[nums.size()];
//        for (int i = 0; i < nums.size(); i++) {
//            int cur = nums.get(i);
//            for (int j = i + 1; j < nums.size(); j++) {
//                if (cur < nums.get(j)) {
//                    res[i] = nums.get(j);
//                    break;
//                }
//            }
//        }
//        return res;
//    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            nums.add(p.val);
            p = p.next;
        }

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.size()]; // default 0
        for (int i = 0; i < nums.size(); i++) {
            while (!stack.isEmpty() && nums.get(stack.lastElement()) < nums.get(i)) {
                res[stack.pop()] = nums.get(i);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9, 7, 6, 7, 6, 9};
        ListNode listNode = new ListNode(nums);
        Solution ss = new Solution();
        int[] res = ss.nextLargerNodes(listNode);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
