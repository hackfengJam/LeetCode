package leetcode.algo.tree.leet_zh_814;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

public class Solution {
    /*
     * 814. 二叉树剪枝
     * 执行用时 : 3 ms
     * 内存消耗 : 34.4 MB
     * */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;

        // 先修剪左右子树
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);


        // 当前节点值为0，且是叶子节点，则需要修剪
        if (root.val == 0 && root.left == null && root.right == null)
            return null;

        return root;
    }


    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
        TreeNode root = codec.deserialize("[1,1,0,1,1,0,1,0]");
        root = ss.pruneTree(root);
        System.out.println(codec.serialize(root));
    }
}