package leetcode.tree.leet_zh_236;

import leetcode.tree.base.TreeNode;
import leetcode.tree.leet_zh_1167.Codec;

public class Solution {
    /*
     * 236. 二叉树的最近公共祖先
     *
     *
     * 执行用时 : 16 ms, 在Lowest Common Ancestor of a Binary Tree的Java提交中击败了50.12% 的用户
     * 内存消耗 : 39.1 MB, 在Lowest Common Ancestor of a Binary Tree的Java提交中击败了5.74% 的用户
     * */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val == p.val || root.val == q.val)
            return root;
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null)
            return root;
        else if (leftNode != null)
            return leftNode;
        else if (rightNode != null)
            return rightNode;
        return null;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
        TreeNode root = codec.deserialize("[3,5,1,6,2,0,8,null,null,7,4]");
//        TreeNode root = codec.deserialize("[3,5,1]");
        System.out.println(ss.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)).val);
        root = codec.deserialize("[3,5,1,6,2,0,8,null,null,7,4]");
        System.out.println(ss.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4)).val);
        root = codec.deserialize("[3,5,1,6,2,0,8,null,null,7,4]");
        System.out.println(ss.lowestCommonAncestor(root, new TreeNode(6), new TreeNode(0)).val);
        System.out.println(ss.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(6)).val);
    }
}