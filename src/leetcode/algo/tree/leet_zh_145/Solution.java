package leetcode.algo.tree.leet_zh_145;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //    public List<Integer> postorderTraversal(TreeNode root) {
//        TreeNode p = root;
//        List<Integer> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        while (true) {
//
//            while (p != null) {
//                stack.push(p);
//                p = p.left != null ? p.left : p.right;
//            }
//            if (stack.empty()) return res;
//            p = stack.pop();
//            res.add(p.val);
//
//            TreeNode temp = p;
//            do {
//                if (stack.empty()) return res;
//                p = stack.firstElement();
//                if (temp == p.right) {
//                    res.add(p.val);
//                    stack.pop();
//                    temp = p;
//                } else {
//                    p = p.right;
//                    break;
//                }
//            } while (true);
//        }
//    }

    /*
     * 145. Binary Tree Postorder Traversal
     * 执行用时 : 1 ms
     * 内存消耗 : 34.1 MB
     * */
    private void postorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null)
            return;

        postorderTraversal(node.left, res);
        postorderTraversal(node.right, res);
        res.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
        TreeNode root = codec.deserialize("[5,1,4,null,null,3,6]");
        root = codec.deserialize("[1,null,2,3]");
        for (Integer i : ss.postorderTraversal(root)) {
            System.out.println(i);
        }
    }
}