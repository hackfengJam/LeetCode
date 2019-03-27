package leetcode.tree.leet_zh_235;

import leetcode.tree.base.TreeNode;
import leetcode.tree.leet_zh_1167.Codec;

public class Solution {
    /*
     * 235. 二叉搜索树的最近公共祖先
     * 执行用时 : 11 ms
     * 内存消耗 : 40.8 MB*/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
        TreeNode root = codec.deserialize("[6,2,8,0,4,7,9,null,null,3,5]");
        System.out.println(ss.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)).val);
        root = codec.deserialize("[6,2,8,0,4,7,9,null,null,3,5]");
        System.out.println(ss.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)).val);
    }
}