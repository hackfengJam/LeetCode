package leetcode.tree.leet_zh_199;

import leetcode.tree.base.TreeNode;
import leetcode.tree.leet_zh_1167.Codec;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * 199. 二叉树的右视图
     *
     * 执行用时 : 5 ms, 在Binary Tree Right Side View的Java提交中击败了6.30% 的用户
     * 内存消耗 : 35.1 MB, 在Binary Tree Right Side View的Java提交中击败了43.50% 的用户
     * */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;
        ans.add(root.val);

        List<Integer> leftAns = rightSideView(root.left);
        List<Integer> rightAns = rightSideView(root.right);

        ans.addAll(rightAns);
        if (leftAns.size() > rightAns.size())
            ans.addAll(leftAns.subList(rightAns.size(), leftAns.size()));
        return ans;

    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();

        TreeNode root = codec.deserialize("[1,2,3,null,5,null,4]");
        root = codec.deserialize("[1]");
        root = codec.deserialize("[1,null,2]");
        List<Integer> ans = ss.rightSideView(root);

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
