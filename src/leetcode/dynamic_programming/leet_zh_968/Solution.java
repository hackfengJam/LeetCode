package leetcode.dynamic_programming.leet_zh_968;

import leetcode.tree.base.TreeNode;
import leetcode.tree.leet_zh_1167.Codec;

public class Solution {
    /*
     * Title: 968. 监控二叉树
     * Link : https://leetcode-cn.com/problems/binary-tree-cameras/
     * Label: ["树", "深度优先搜索", "动态规划"]
     * Level: Hard
     * Desc :
     *给定一个二叉树，我们在树的节点上安装摄像头。
    节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
    计算监控树的所有节点所需的最小摄像头数量

    输入：[0,0,null,0,0]
    输出：1
    解释：如图所示，一台摄像头足以监控所有节点。

    输入：[0,0,null,0,null,0,null,null,0]
    输出：2
    解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。

    * 提示：
        给定树的节点数的范围是 [1, 1000]。
        每个节点的值都是 0。
     *
     * 执行用时 : 1 ms
     * 内存消耗 : 38.4 MB
     *
     * 官方题解
     * 状态 a：root 必须放置摄像头的情况下，覆盖整棵树需要的摄像头数目。
       状态 b：覆盖整棵树需要的摄像头数目，无论 root 是否放置摄像头。
       状态 c：覆盖两棵子树需要的摄像头数目，无论节点 root 本身是否被监控到。
     * 根据定义，一定有：a >= b >= c
     *
     * a = Lc + Rc + 1
     * b = min(a, min(La + Rb, Ra + Lb))
     *
     *
     * 对于 c 而言，要保证两棵子树被完全覆盖，要么 root 处放置一个摄像头，需要的摄像头数目为 a；
     * 要么 root 处不放置摄像头，此时两棵子树分别保证自己被覆盖，
     * 需要的摄像头数目为 Lb + Rb
     *
     * 需要额外注意的是，对于 root 而言，如果其某个孩子为空，
     * 则不能通过在该孩子处放置摄像头的方式，监控到当前节点。因此，
     * 该孩子对应的变量 a 应当返回一个大整数，用于标识不可能的情形。
     * 最终，根节点的状态变量 b 即为要求出的答案。
     * * */

    //    int f, t = 0;
//
//    private void dfs(TreeNode root, boolean parentColor) {
//        if (root == null) {
//            return;
//        }
//        boolean curColor = !parentColor;
//        if (curColor) {
//            t++;
//        } else {
//            f++;
//        }
//        dfs(root.left, curColor);
//        dfs(root.right, curColor);
//    }
//
//    public int minCameraCover(TreeNode root) {
//        f = 0;
//        t = 0;
//        dfs(root, true);
//        if (f == 0) return t;
//        if (t == 0) return f;
//        return Math.min(f, t);
//    }
    private class Status {
        public int a, b, c;

        public Status() {
        }

        public Status(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }

    private Status dfs(TreeNode root) {
        if (root == null)
            // Integer.MAX_VALUE / 2, 否则会溢出
            return new Status(Integer.MAX_VALUE / 2, 0, 0);
        Status L = dfs(root.left);
        Status R = dfs(root.right);

        int a = L.c + R.c + 1;
        int b = Math.min(a, Math.min(L.a + R.b, L.b + R.a));
        int c = Math.min(a, L.b + R.b);

        return new Status(a, b, c);
    }

    public int minCameraCover(TreeNode root) {
        return dfs(root).b;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        Codec codec = new Codec();
        System.out.println(ss.minCameraCover(codec.deserialize("[0]")));
        System.out.println(ss.minCameraCover(codec.deserialize("[0,0,null,0,0]")));
        System.out.println(ss.minCameraCover(codec.deserialize("[0,0,null,0,null,0,null,null,0]")));
    }
}
