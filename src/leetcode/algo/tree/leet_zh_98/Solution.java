package leetcode.algo.tree.leet_zh_98;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
    * 执行用时 : 4 ms
    * 内存消耗 : 37.7 MB
    * */
    private void inOrdered(TreeNode node, List<Integer> res) {
        if (node == null)
            return;

        inOrdered(node.left, res);
        res.add(node.val);
        inOrdered(node.right, res);
    }

    public boolean isValidBST(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        inOrdered(root, res);
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
        TreeNode root = codec.deserialize("[5,1,4,null,null,3,6]");
        System.out.println(ss.isValidBST(root));
        root = codec.deserialize("[2,1,3]");
        System.out.println(ss.isValidBST(root));
        root = codec.deserialize("[1,1]");
        System.out.println(ss.isValidBST(root));
    }
}