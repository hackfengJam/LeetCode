package nowcoder.offer.reConstructBinaryTree;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

public class Solution {
    /*
     *
     * 重建二叉树
     *
        时间限制：1秒 空间限制：32768K 热度指数：602504
        算法知识视频讲解
        题目描述
        输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
        例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

        [1,2,3,4,null,5,6,null,7,null,null,8]

     * 运行时间：292ms
     * 占用内存：22880k
     * */
    private int[] pre;
    private int[] in;

    private TreeNode conS(int preI, int preJ, int inI, int inJ) {
        if (preI >= preJ || inI >= inJ)
            return null;
        int rootVal = pre[preI];
        TreeNode node = new TreeNode(rootVal);
        int des = -1;
        for (int j = inI; j < inJ; j++) {
            if (in[j] == rootVal) {
                des = j;
                break;
            }
        }
        if (des == -1) return null;
        int cnt = des - inI;

        // 构建左子树
        node.left = conS(preI + 1, preI + 1 + cnt, inI, inI + cnt);

        // 构建右子树
        node.right = conS(preI + 1 + cnt, preJ, inI + cnt + 1, inJ);
        return node;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length < 1)
            return null;
        this.pre = pre;
        this.in = in;
        return conS(0, pre.length, 0, in.length);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
//        int[] pre = {1, 2, 3};
//        int[] in = {2, 1, 3};
        System.out.println(codec.serialize(ss.reConstructBinaryTree(pre, in)));

    }
}