package hw_interview.leetcode_zh_110;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

public class Solution {
    /*
     * Title:
     * Link :
     * Label: [""]
     * Level: Hard
     * Desc :
     *
     * 执行用时 :  ms
     * 内存消耗 :  MB
     * */
    public int height(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return 1;

        if (root.left == null) {
            return height(root.right) + 1;
        } else if (root.right == null) {
            return height(root.left) + 1;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        // 记事本 memo[root] = ...
        // return memo[root] != 0 ?

        int leftH = height(root.left);
        int rightH = height(root.right);
        boolean ret = Math.abs(leftH - rightH) <= 1;
        return isBalanced(root.left) && isBalanced(root.right) && ret;
    }


    public static void main(String[] args) {
        Solution ss = new Solution();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[1,2,2,3,null,null,3,4,null,null,4]");
        System.out.println(ss.isBalanced(root));
    }
}
