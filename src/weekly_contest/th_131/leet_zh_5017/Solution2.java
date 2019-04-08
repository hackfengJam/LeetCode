package weekly_contest.th_131.leet_zh_5017;

import leetcode.tree.base.TreeNode;
import leetcode.tree.leet_zh_1167.Codec;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    private List<String> dfs(TreeNode node) {
        List<String> ans = new ArrayList<>();
        if (node == null) {
            return ans;
        }
        if (node.left == null && node.right == null) {
            ans.add(("" + node.val));
            return ans;
        }

        for (String str : dfs(node.left)) {
            ans.add((node.val + "") + str);
        }
        for (String str : dfs(node.right)) {
            ans.add((node.val + "") + str);
        }
        return ans;
    }

    private String generateZero(int ln) {
        if (ln == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for (; ln > 0; ln--) sb.append('0');
        return sb.toString();
    }

    public int sumRootToLeaf(TreeNode root) {
        List<String> ans = dfs(root);
        int total = 0;
        int ln = 0;
        for (String str : ans) {
            if (str.length() > ln) {
                ln = str.length();
            }
        }
        for (String str : ans) {
            total += Integer.parseInt(str + generateZero(ln - str.length()), 2);
        }

        return total;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution2 ss = new Solution2();

        TreeNode root;
        root = codec.deserialize("[1,0,1]");
        root = codec.deserialize("[1,0,1,0,1]");
        root = codec.deserialize("[1,0,1,0,1,0,1]");
        System.out.println(ss.sumRootToLeaf(root));
    }
}
