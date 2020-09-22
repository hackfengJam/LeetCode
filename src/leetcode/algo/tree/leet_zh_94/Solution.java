package leetcode.algo.tree.leet_zh_94;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

import java.util.*;

public class Solution {
    /*
     * 94. Binary Tree Inorder Traversal
     * 执行用时 : 1 ms
     * 内存消耗 : 36.3 MB
     * */
//    private void inOrder(TreeNode node, List<Integer> res) {
//        if (node == null) {
//            return;
//        }
//        inOrder(node.left, res);
//        res.add(node.val);
//        inOrder(node.right, res);
//    }


    /*
     *
     * 执行用时 : 2 ms
     * 内存消耗 : 34 MB
     * */
    private void pushToStack(Stack<TreeNode> stack, TreeNode node) {
        if (node == null) {
//            stack.push(null);
            return;
        }
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
//        stack.push(null);
    }

    private void inOrder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        pushToStack(stack, node);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (treeNode != null) {
                res.add(treeNode.val);
                pushToStack(stack, treeNode.right);
            } else {
                res.add(null);
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
        TreeNode root = codec.deserialize("[5,1,4,null,null,3,6]");
        root = codec.deserialize("[1,null,2,3]");
        for (Integer i : ss.inorderTraversal(root)) {
            System.out.println(i);
        }
    }
}
