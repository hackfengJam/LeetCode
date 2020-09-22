package weekly_contest.th_135.leet_zh_5050;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

public class Solution {
    /*
     *
     * 5050. 从二叉搜索树到更大和树
     * */
    private int bst(TreeNode node, int val) {
        if (node == null)
            return val;
        if (node.right != null)
            val = bst(node.right, val);

        val += node.val;
        node.val = val;

        if (node.left != null) {
            val = bst(node.left, val);
        }
        return val;
    }

    public TreeNode bstToGst(TreeNode root) {
        bst(root, 0);
        return root;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]");
        System.out.println(codec.serialize(ss.bstToGst(root)));

    }
}
