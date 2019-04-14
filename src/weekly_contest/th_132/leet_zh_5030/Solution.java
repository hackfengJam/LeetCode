package weekly_contest.th_132.leet_zh_5030;

import leetcode.tree.base.TreeNode;
import leetcode.tree.leet_zh_1167.Codec;


public class Solution {
    private int searchMax(TreeNode node, int max, int min) {
        if (node == null)
            return 0;
        int ans = Math.max(node.val - min, max - node.val);
        min = Math.min(node.val, min);
        max = Math.max(node.val, max);
        ans = Math.max(ans, Math.max(searchMax(node.left, max, min), searchMax(node.right, max, min)));

        return ans;
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;
        return searchMax(root, root.val, root.val);
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        Codec cc = new Codec();
        TreeNode root;
        root = cc.deserialize("[8,3,10,1,6,null,14,null,null,4,7,13]");

        System.out.println(ss.maxAncestorDiff(root));

    }
}
