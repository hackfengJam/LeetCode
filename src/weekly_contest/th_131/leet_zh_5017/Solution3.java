package weekly_contest.th_131.leet_zh_5017;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

public class Solution3 {

    private int dfs(TreeNode node, int dp) {
        if (node == null)
            return 0;
//        return ((int) (node.val * Math.pow(2, dp - 1))) + dfs(node.left, dp - 1) + dfs(node.right, dp - 1);
        int total = (int) (node.val * Math.pow(2, dp - 1));

        if (node.left == null && node.right == null)
            return total;
        int leftVal = dfs(node.left, dp - 1);
        int rightVal = dfs(node.right, dp - 1);
        return total * leafCount(node, 0) + leftVal + rightVal;
    }

    private int leafCount(TreeNode node, int total) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return total + 1;
        return leafCount(node.left, total) + leafCount(node.right, total);
    }

    private int dp(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(dp(node.left), dp(node.right)) + 1;
    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, dp(root));
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution3 ss = new Solution3();

        TreeNode root;
//        root = codec.deserialize("[1]");
//        root = codec.deserialize("[1,0,1]");
        root = codec.deserialize("[1,0,1,0,1]"); // 4 + 5 + 3
        root = codec.deserialize("[1,0,1,0,1,0,1]");
        root = codec.deserialize("[0,1,0,0,null,0,0,null,null,null,1,null,null,null,1]");
        System.out.println(ss.dp(root));
        System.out.println(ss.leafCount(root, 0));

        System.out.println(ss.sumRootToLeaf(root));
    }
}
