package leetcode.tree.leet_zh_113;

import leetcode.tree.base.TreeNode;
import leetcode.tree.leet_zh_1167.Codec;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
     * 执行用时 : 5 ms
     * 内存消耗 : 36.4 MB*/
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.left == null && root.right == null)
            if (root.val == sum) {
                List<List<Integer>> res = new ArrayList<>();
                List<Integer> line = new ArrayList<>();
                line.add(root.val);
                res.add(line);
                return res;
            }

        List<List<Integer>> leftLines = pathSum(root.left, sum - root.val);
        for (List<Integer> line : leftLines) {
            line.add(0, root.val);
        }
        List<List<Integer>> rightLines = pathSum(root.right, sum - root.val);
        for (List<Integer> line : rightLines) {
            line.add(0, root.val);
        }

        leftLines.addAll(rightLines);
        return leftLines;

    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
        TreeNode root = codec.deserialize("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        System.out.println(ss.pathSum(root, 22));
    }
}