package weekly_contest.th_136.leet_zh_5055;

public class Solution {
    /*
     *
     * 5055. 困于环中的机器人
     *
     * 108 / 108 个通过测试用例
     * 执行用时：2 ms
     *
     * */
    private int[][] dire = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int curD = 0;

        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            if (c == 'G') {
                x += dire[curD][0];
                y += dire[curD][1];
            } else if (c == 'L') {
                curD = (curD + 3) & 3;
            } else if (c == 'R') {
                curD = (curD + 1) & 3;
            }
        }
        if (x == 0 && y == 0)
            return true;
        return curD != 0;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.isRobotBounded("GGLLGG"));
    }
}
