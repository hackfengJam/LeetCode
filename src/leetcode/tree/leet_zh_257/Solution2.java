package leetcode.tree.leet_zh_257;

import leetcode.tree.base.TreeNode;
import leetcode.tree.leet_zh_1167.Codec;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    /*
     * Title: 257. 二叉树的所有路径
     * Link : https://leetcode-cn.com/problems/binary-tree-paths/
     * Label: ["树" ,"深度优先遍历"]
     * Level: Easy
     * Desc :
     *给定一个二叉树，返回所有从根节点到叶子节点的路径。
        说明: 叶子节点是指没有子节点的节点。
        示例:

        输入:

           1
         /   \
        2     3
         \
          5

        输出: ["1->2->5", "1->3"]

        解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     * 执行用时 : 1 ms
     * 内存消耗 : 39.9 MB
     * */
    public void dfs(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder pathB = new StringBuilder(path);
            pathB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                paths.add(pathB.toString());
            } else {
                pathB.append("->");
                dfs(root.left, pathB.toString(), paths);
                dfs(root.right, pathB.toString(), paths);
            }
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        dfs(root, "", ret);
        return ret;
    }

    public static void main(String[] args) {
        Solution2 ss = new Solution2();
        Codec codec = new Codec();
        System.out.println(ss.binaryTreePaths(codec.deserialize("[1,2,3,null,5]")));
        ;
    }
}
