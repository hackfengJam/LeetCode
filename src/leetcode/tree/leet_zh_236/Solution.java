package leetcode.tree.leet_zh_236;

import leetcode.tree.base.TreeNode;
import leetcode.tree.leet_zh_1167.Codec;

public class Solution {
    /*
     * 236. 二叉树的最近公共祖先
     *
     *
     * 执行用时 : 9 ms, 在Lowest Common Ancestor of a Binary Tree的Java提交中击败了96.17% 的用户
     * 内存消耗 : 34.5 MB, 在Lowest Common Ancestor of a Binary Tree的Java提交中击败了84.61% 的用户
     * */
    private TreeNode ret;
    private TreeNode findP;
    private TreeNode findQ;

    private TreeNode lowest(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;
        if (ret != null)
            return ret;

        boolean isF = false;

        // 进入时已经找到过 p 或 q，那么本节点不会是p、q父亲节点
        if (findP != null || findQ != null) {
            isF = true;
        }

        ret = lowest(node.left, p, q);
        if (ret != null)
            return ret;
        ret = lowest(node.right, p, q);
        if (ret != null)
            return ret;

        if (p.val == node.val) {
            findP = node;
        }
        if (q.val == node.val) {
            findQ = node;
        }

        // 进入时已经找到过 p 或 q，那么本节点不会是p、q父亲节点
        if (!isF && findP != null && findQ != null)
            return node;

        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ret = null;
        findP = null;
        findQ = null;
        ret = lowest(root, p, q);
        return ret;
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