package weekly_contest.th_135.leet_zh_5047;

public class Solution {
    /*
     *
     * 5047. 多边形三角剖分的最低得分
     *
     给定 N，想象一个凸 N 边多边形，其顶点按顺时针顺序依次标记为 A[0], A[i], ..., A[N-1]。
     假设您将多边形剖分为 N-2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 N-2 个三角形的值之和。
     返回多边形进行三角剖分后可以得到的最低分。

        输入：[1,2,3]
        输出：6
        解释：多边形已经三角化，唯一三角形的分数为 6。

        输入：[3,7,4,5]
        输出：144
        解释：有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。

        输入：[1,3,1,4,1,5]
        输出：13
        解释：最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
     * */
    public int minScoreTriangulation(int[] A) {
        int ret = -1;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = (i + 1) % A.length; (j + 1) % A.length != i; j = (j + 1) % A.length) {
                int k = (j + 1) % A.length;
                sum += A[i] * A[j] * A[k];
            }
            if (ret == -1)
                ret = sum;
            if (sum < ret)
                ret = sum;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
//        int[] nums = {1, 2, 3};
//        int[] nums = {3,7,4,5};
        int[] nums = {1,3,1,4,1,5};
        System.out.println(ss.minScoreTriangulation(nums));
    }
}
