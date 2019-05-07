package weekly_contest.th_135.leet_zh_5051;

public class Solution {
    /*
     *
     * 5051. 有效的回旋镖
     *
     *
        输入：[[1,1],[2,3],[3,2]]
        输出：true

        输入：[[1,1],[2,2],[3,3]]
        输出：false

        x2 - x1  x3 - x2
        y2 - y1  y3 - y2

        (x2 - x1)*(y3 - y2) = (x3 - x2)*(y2 - y1)

     * */
    public boolean isBoomerang(int[][] points) {
        if (points[1][1] - points[0][1] == 0 && points[2][1] - points[0][1] == 0) return false;

        return (points[1][0] - points[0][0]) * (points[2][1] - points[1][1]) - (points[2][0] - points[1][0]) * (points[1][1] - points[0][1]) != 0;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();

//        int[][] points = {{1, 1}, {2, 3}, {3, 2}};
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
//        int[][] points = {{0, 1}, {0, 2}, {0, 3}};
        System.out.println(ss.isBoomerang(points));
    }
}