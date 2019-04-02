package leetcode.backtrack.leet_zh_101;

import leetcode.tree.base.TreeNode;
import leetcode.tree.leet_zh_1167.Codec;

public class Solution {
    /*
     *
     * 执行用时 : 2 ms
     * 内存消耗 : 34.5 MB
     * */
    private boolean isS(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null)
            return true;

        if (leftNode != null && rightNode != null && leftNode.val == rightNode.val) {
            return isS(leftNode.left, rightNode.right) && isS(leftNode.right, rightNode.left);
        }

        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isS(root.left, root.right);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
        TreeNode root = codec.deserialize("[1,2,2,3,4,4,3]");
        System.out.println(ss.isSymmetric(root));
        root = codec.deserialize("[1,2,2,null,3,null,3]");
        System.out.println(ss.isSymmetric(root));
    }
}
