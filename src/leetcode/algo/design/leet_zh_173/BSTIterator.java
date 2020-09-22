package leetcode.algo.design.leet_zh_173;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class BSTIterator {
    /*
     *
     * 173. 二叉搜索树迭代器
     * 利用二叉树的迭代方式的中序遍历，保存左子链，从而使用O(h)的内存。
     *
     * 执行用时 : 134 ms, 在Binary Search Tree Iterator的Java提交中击败了81.31% 的用户
     * 内存消耗 : 59.4 MB, 在Binary Search Tree Iterator的Java提交中击败了81.28% 的用户
     * */
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushToStack(root);
    }

    private void pushToStack(TreeNode node) {
        if (node == null)
            return;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        if (node != null) {
            pushToStack(node.right);
            return node.val;
        }
        return -1;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root;
        root = codec.deserialize("[7,3,15,null,null,9,20]");

        BSTIterator bstIterator = new BSTIterator(root);
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