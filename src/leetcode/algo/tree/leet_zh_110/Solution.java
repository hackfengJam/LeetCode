package leetcode.algo.tree.leet_zh_110;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

public class Solution {
    /*
     * 执行用时 : 2 ms
     * 内存消耗 : 36.9 MB*/
    private static final int notBalanced = -1;

    private int cntHeightAndBalanced(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = cntHeightAndBalanced(node.left);
        int rightHeight = cntHeightAndBalanced(node.right);
        if (leftHeight == notBalanced || rightHeight == notBalanced)
            return notBalanced;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return notBalanced;

        return Math.max(leftHeight, rightHeight) + 1;
    }


    public boolean isBalanced(TreeNode root) {
        return cntHeightAndBalanced(root) != -1;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
        TreeNode root = codec.deserialize("[3,9,20,null,null,15,7]");
        System.out.println(ss.isBalanced(root));
        root = codec.deserialize("[1,2,2,3,3,null,null,4,4]");
        System.out.println(ss.isBalanced(root));
    }
}