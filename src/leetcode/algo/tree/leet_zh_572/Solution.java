package leetcode.algo.tree.leet_zh_572;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

public class Solution {
    /*
     * 572. 另一个树的子树
     *
     * 执行用时 : 15 ms, 在Subtree of Another Tree的Java提交中击败了79.90% 的用户
     * 内存消耗 : 40.5 MB, 在Subtree of Another Tree的Java提交中击败了93.99% 的用户
     * */
    private boolean isEqual(TreeNode s, TreeNode t) {
        if (s == null || t == null)
            return s == t;
        if (s.val == t.val) {
            return isEqual(s.left, t.left) && isEqual(s.right, t.right);
        } else return false;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null)
            return s == t;
        if (s.val == t.val && isEqual(s, t)) {
            return true;
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        Codec codec = new Codec();
        TreeNode s = codec.deserialize("[3,4,5,1,2]");
        TreeNode t = codec.deserialize("[4,1,2]");
        System.out.println(ss.isSubtree(s, t));
    }
}
