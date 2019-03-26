package leetcode.tree.leet_zh_112;

import leetcode.tree.base.TreeNode;
import leetcode.tree.leet_zh_1167.Codec;

class Solution {
    /*
     * 执行用时 : 1 ms
     * 内存消耗 : 38.4 MB*/
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return root.val == sum;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
        TreeNode root = codec.deserialize("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        System.out.println(ss.hasPathSum(root, 22));
    }
}