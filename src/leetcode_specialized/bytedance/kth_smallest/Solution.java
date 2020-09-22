package leetcode_specialized.bytedance.kth_smallest;

import leetcode.algo.tree.base.TreeNode;

public class Solution {
    /*
     * Title: 二叉搜索树中第K小的元素
     * Link : https://leetcode-cn.com/leetbook/read/top-interview-questions/xazo8d/
     * Label: [""]
     * Level: Easy
     * Desc :
     *给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

        说明：
        你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

        示例 1:

        输入: root = [3,1,4,null,2], k = 1
           3
          / \
         1   4
          \
           2
        输出: 1
        示例 2:

        输入: root = [5,3,6,2,4,null,null,1], k = 3
               5
              / \
             3   6
            / \
           2   4
          /
         1
        输出: 3
        进阶：
        如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？

     * 执行用时 : 0 ms
     * 内存消耗 : 39.6 MB
     * */
    private int index = 0;
    private int ret = 0;

    private void traverse(TreeNode root, int k) {
        if (index == k)
            return;
        if (root == null)
            return;
        if (root.left != null)
            traverse(root.left, k);
        index++;
        if (index == k) {
            ret = root.val;
            return;
        }
        if (root.right != null)
            traverse(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        index = 0;
        ret = 0;
        traverse(root, k);
        return ret;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
    }
}
