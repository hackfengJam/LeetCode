package leetcode.algo.tree.leet_zh_108;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

public class Solution {

    /*
     * 108. Convert Sorted Array to Binary Search Tree
     * 执行用时 : 1 ms 击败 97.11%
     * 内存消耗 : 37.5 MB
     * */

    /*
     *
     * 二分生成 BST
     * */
    private TreeNode gBST(int[] nums, int l, int r) {
        if (l >= r) {
            return null;
        }

        // [l,mid), mid, [mid+1, r)
        int mid = l + (r - l) / 2;

        // mid
        TreeNode node = new TreeNode(nums[mid]);
        // [l, mid)
        node.left = gBST(nums, l, mid);
        // [mid+1, r)
        node.right = gBST(nums, mid + 1, r);

        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return gBST(nums, 0, nums.length);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
        int[] nums = {-10, -3, 0, 5, 9};
//        int[] nums = {-101};
        System.out.println(codec.serialize(ss.sortedArrayToBST(nums)));
    }
}
