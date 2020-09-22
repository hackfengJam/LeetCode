package leetcode.algo.tree.leet_zh_530;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * 执行用时 : 16 ms
     * 内存消耗 : 44.3 MB
     * */
    private List<TreeNode> inOrder(TreeNode node) {
        List<TreeNode> res = new ArrayList<>();
        if (node == null)
            return res;
        res.addAll(inOrder(node.left));
        res.add(node);
        res.addAll(inOrder(node.right));
        return res;
    }

    public int getMinimumDifference(TreeNode root) {
        List<TreeNode> res = inOrder(root);
        int min = -1;
        for (int i = 0; i < res.size() - 1; i++) {
            int val = res.get(i + 1).val - res.get(i).val;
            if (min == -1)
                min = val;
            else
                min = Math.min(min, val);
        }

        return min;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
        TreeNode root;
//        root = codec.deserialize("[1,null,3,2]");
        root = codec.deserialize("[3,1,null]");
//        root = codec.deserialize("[5,4,7]");
//        root = codec.deserialize("[543,384,652,null,445,null,699]");
//        System.out.println(ss.floor(root, 1).val);
//        System.out.println(ss.ceil(root, 1).val);

//        System.out.println(ss.treeToDoubleList(root));
        System.out.println(ss.getMinimumDifference(root));
    }
}
