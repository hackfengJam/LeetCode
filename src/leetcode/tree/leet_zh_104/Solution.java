package leetcode.tree.leet_zh_104;

import leetcode.tree.base.TreeNode;
import leetcode.tree.leet_zh_1167.Codec;

public class Solution {
    /*
     *
     * 104. 二叉树的最大深度 - 递归
     *
     * 39 / 39 个通过测试用例
     * 执行用时 : 1 ms
     * 内存消耗 : 35.9 MB
     * */
    private int max;

    private void maxD(TreeNode root, int dp) {
        if (root == null)
            return;
        max = Math.max(dp, max);
        maxD(root.left, dp + 1);
        maxD(root.right, dp + 1);
    }

    public int maxDepth(TreeNode root) {
        max = 0;
        maxD(root, 1);
        return max;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
        TreeNode root = codec.deserialize("[3,9,20,null,null,15,7]");
        System.out.println(ss.maxDepth(root));
    }

}
