package leetcode.algo.tree.leet_zh_114;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

public class Solution {
    /*
     * 114. 二叉树展开为链表
     *
     * 执行用时 : 1 ms, 在Flatten Binary Tree to Linked List的Java提交中击败了99.88% 的用户
     * 内存消耗 : 36.7 MB, 在Flatten Binary Tree to Linked List的Java提交中击败了79.77% 的用户
     * */
    private TreeNode flatt(TreeNode node) {
        if (node == null)
            return null;
        if (node.left == null && node.right == null) {
            return node;
        }
        TreeNode lastLeftNode = flatt(node.left);
        TreeNode lastRightNode = flatt(node.right);

        if (lastLeftNode != null) {
            TreeNode tmp = node.right;
            node.right = node.left;

            lastLeftNode.right = tmp;

            node.left = null;
        }
        if (lastRightNode == null) {
            lastRightNode = lastLeftNode;
        }
        return lastRightNode;
    }

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatt(root);
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        Codec codec = new Codec();

//        TreeNode root = codec.deserialize("[1,2,5]");
//        TreeNode root = codec.deserialize("[1,2,null,3]");
        TreeNode root = codec.deserialize("[1,2,5,3,4,null,6]");
        ss.flatten(root);
        System.out.println(codec.serialize(root));


    }
}