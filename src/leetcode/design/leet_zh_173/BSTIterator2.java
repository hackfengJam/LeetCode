package leetcode.design.leet_zh_173;

import leetcode.tree.base.TreeNode;
import leetcode.tree.leet_zh_1167.Codec;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class BSTIterator2 {
    /*
     *
     * 173. 二叉搜索树迭代器
     *
     * 空间复杂度O(1)，next()平均时间复杂度O(1)
     * 执行用时 : 140 ms, 在Binary Search Tree Iterator的Java提交中击败了71.25% 的用户
     * 内存消耗 : 67.9 MB, 在Binary Search Tree Iterator的Java提交中击败了5.07% 的用户
     * */
    private TreeNode node;

    public BSTIterator2(TreeNode root) {
        node = root;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        while (node != null) {
            if (node.left != null) {
                TreeNode tmp = node.left;
                while (tmp.right != null) tmp = tmp.right;
                tmp.right = node;

                tmp = node.left;
                node.left = null;
                node = tmp;
            } else {
                int next = node.val;
                node = node.right;
                return next;
            }
        }
        return -1;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return node != null;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root;
        root = codec.deserialize("[7,3,15,null,null,9,20]");

        BSTIterator2 bstIterator = new BSTIterator2(root);
        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }

    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */