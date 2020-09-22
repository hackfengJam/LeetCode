package leetcode.algo.tree.leet_zh_104;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    /*
     *
     * 104. 二叉树的最大深度 - 迭代
     *
     * 39 / 39 个通过测试用例
     * 执行用时 : 6 ms
     * 内存消耗 : 35.6 MB
     * */
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;

        Queue<List<TreeNode>> queue = new LinkedList<>();


        // 每层用单独链表存储
        List<TreeNode> levelList = new ArrayList<>();
        levelList.add(root);

        // 初始化队列
        queue.offer(levelList);

        // 轮询队列
        while (!queue.isEmpty()) {
            depth++;
            levelList = queue.poll();

            // 存储下一层节点链表
            List<TreeNode> levelChildList = new ArrayList<>();

            // 遍历当前层并放入下一层节点链表
            for (TreeNode node : levelList) {
                if (node.left != null)
                    levelChildList.add(node.left);
                if (node.right != null)
                    levelChildList.add(node.right);
            }

            if (levelChildList.size() > 0)
                queue.offer(levelChildList);
        }

        return depth;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution2 ss = new Solution2();
        TreeNode root = codec.deserialize("[3,9,20,null,null,15,7]");
        System.out.println(ss.maxDepth(root));
    }

}
