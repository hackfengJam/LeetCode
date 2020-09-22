package leetcode_specialized.offer.leet_zh_54;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

public class Solution {
    /*
     * Title: 剑指 Offer 54. 二叉搜索树的第k大节点
     * Link : https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
     * Label: ["树"]
     * Level: Easy
     * Desc :
     *给定一棵二叉搜索树，请找出其中第k大的节点。
        示例 1:

        输入: root = [3,1,4,null,2], k = 1
           3
          / \
         1   4
          \
           2
        输出: 4
        示例 2:

        输入: root = [5,3,6,2,4,null,null,1], k = 3
               5
              / \
             3   6
            / \
           2   4
          /
         1
        输出: 4
         

        限制：

        1 ≤ k ≤ 二叉搜索树元素个数
     * 执行用时 : 1 ms
     * 内存消耗 : 39.7 MB
     * */
    private int index = 0;
    private int ret = 0;

    private void traverse(TreeNode root, int k) {
        if (index == k)
            return;
        if (root == null)
            return;
        if (root.right != null)
            traverse(root.right, k);
        index++;
        if (index == k) {
            ret = root.val;
            return;
        }
        if (root.left != null)
            traverse(root.left, k);
    }

    public int kthLargest(TreeNode root, int k) {
        index = 0;
        ret = 0;
        traverse(root, k);
        return ret;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        Codec codec = new Codec();
        System.out.println(ss.kthLargest(codec.deserialize("[3,1,4,null,2]"), 1));
//        System.out.println(ss.kthLargest(codec.deserialize("[5,3,6,2,4,null,null,1]"), 3));
    }
}
