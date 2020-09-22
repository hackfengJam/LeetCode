package leetcode.algo.tree.leet_zh_145;


import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Stack;

public class PostOrderTraversal {

    private static Stack<TreeNode> stack = new Stack<TreeNode>();
    private static HashSet<TreeNode> resultsMap = new HashSet<TreeNode>();
    private static ArrayList<Integer> result = new ArrayList<Integer>();

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[5,1,4,null,null,3,6]");
        root = codec.deserialize("[1,null,2,3]");
        postOrderTraversal(root);
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    private static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("root should not be null");
        }
        TreeNode currentNode = root;
        while (true) {
            // 判断左子树是否被遍历。
            // 如果左子树为空，则认为左子树被遍历
            if (isLeftSubtreeTraversaled(currentNode)) {
                // 同理于左子树
                if (isRightSubtreeTraversaled(currentNode)) {
                    saveResultNode(currentNode);
                    try {
                        currentNode = stack.pop();
                    } catch (EmptyStackException e) {
                        currentNode = null;
                    }
                } else {
                    stack.push(currentNode);
                    currentNode = currentNode.right;
                }
            } else {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            if (currentNode == null) {
                break;
            }
        }
    }

    private static void saveResultNode(TreeNode node) {
        result.add(node.val);
        resultsMap.add(node);
    }

    private static boolean isLeftSubtreeTraversaled(TreeNode node) {
        return node.left == null || resultsMap.contains(node.left);
    }

    private static boolean isRightSubtreeTraversaled(TreeNode node) {
        return node.right == null || resultsMap.contains(node.right);
    }
}