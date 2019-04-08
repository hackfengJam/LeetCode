package weekly_contest.th_131.leet_zh_5017;

import leetcode.tree.leet_zh_1167.Codec;
import leetcode.tree.base.TreeNode;


public class Solution {
    private int MOD = 1000000007;
    private int total;

    private void dfs(TreeNode node, int cur) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            total = (total + cur) % MOD;
            return;
        }
        if (node.left != null)
            dfs(node.left, (cur * 2 + node.left.val) % MOD);
        if (node.right != null)
            dfs(node.right, (cur * 2 + node.right.val) % MOD);
    }


    public int sumRootToLeaf(TreeNode root) {
        total = 0;
        dfs(root, root.val);
        return total;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();

        TreeNode root;
//        root = codec.deserialize("[1,0,1]");
//        root = codec.deserialize("[1,0,1,0,1]");
//        root = codec.deserialize("[1,0,1,0,1,0,1]");
        root = codec.deserialize("[0,1,0,0,null,0,0,null,null,null,1,null,null,null,1]");
        System.out.println(ss.sumRootToLeaf(root));
    }
}
