package leetcode.algo.dynamic_programming.leet_zh_124;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

public class Solution {
    /*
     * 124. 二叉树中的最大路径和
     * 执行用时 : 3 ms, 在Binary Tree Maximum Path Sum的Java提交中击败了81.44% 的用户
     * 内存消耗 : 41.8 MB, 在Binary Tree Maximum Path Sum的Java提交中击败了80.93% 的用户

     * 最大值只有四种情况：节点， 节点及左树，节点及右树，左右树及节点。最后一种情况不能作为左右树继续递归，需要保存临时最大值，
     *
     * */
    private int ret;
    private final int _INF = Integer.MIN_VALUE;

    public int maxSum(TreeNode root) {
        if (root == null)
            return _INF;
        int leftV = maxSum(root.left);
        int rightV = maxSum(root.right);
        int tmpMax, local, tmp;
        tmpMax = root.val;

        // 节点及左树
        tmp = leftV + root.val;
        if (tmpMax < tmp && leftV != _INF)
            tmpMax = tmp;

        // 节点及右树
        tmp = rightV + root.val;
        if (tmpMax < tmp && rightV != _INF)
            tmpMax = tmp;


        // 左右树及节点，不能作为左右树继续递归
        local = root.val;
        if (leftV != _INF)
            local += leftV;
        if (rightV != _INF)
            local += rightV;

        if (local < tmpMax)
            local = tmpMax;

        ret = ret > local ? ret : local;

        return tmpMax;
    }

    public int maxPathSum(TreeNode root) {
        ret = _INF;
        maxSum(root);
        return ret;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        Codec codec = new Codec();
        System.out.println(ss.maxPathSum(codec.deserialize("[1,2,3]")));
        System.out.println(ss.maxPathSum(codec.deserialize("[-10,9,20,null,null,15,7]")));
        System.out.println(ss.maxPathSum(codec.deserialize("[-3]")));
        System.out.println(ss.maxPathSum(codec.deserialize("[-1,-2,null]")));
//
//        System.out.println(ss._INF + ss._INF + ss._INF);
//        System.out.println(ss._INF + ss._INF);
//        System.out.println(ss._INF);
//        System.out.println(1 << 31);

    }
}
