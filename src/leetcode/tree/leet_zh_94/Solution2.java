package leetcode.tree.leet_zh_94;

import leetcode.tree.base.TreeNode;

import java.util.Stack;

public class Solution2 {
    public void inOrder2(TreeNode root)      //非递归中序遍历
    {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.empty()) {
                p = stack.firstElement();
                System.out.println(p.val);
                stack.pop();
                p = p.right;
            }
        }
    }
}
