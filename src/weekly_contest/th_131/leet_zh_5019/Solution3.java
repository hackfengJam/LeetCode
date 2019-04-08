package weekly_contest.th_131.leet_zh_5019;

import java.util.Arrays;

public class Solution3 {
    public int videoStitching(int[][] clips, int T) {
        int[][] seg = new int[clips.length][2];
        for (int i = 0; i < clips.length; i++) {
            seg[i] = clips[i];
        }

        // clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]]

        // sort -> [[8,10],[1,9],[5,9],[4,6],[1,5],[0,2]]
        Arrays.sort(seg, (a, b) -> b[1] - a[1] != 0 ? b[1] - a[1] : (b[1] - b[0]) - (a[1] - a[0]));
        int res = 0;
        int cur = T;
        int i = 0;
        int ln = seg.length;
        while (cur != 0 || i < ln) {

            // 当前需要找到的最小 start
            // 当 min = T 时，代表未开始寻找
            int min = cur;

            // 确保 seg[i].end >= cur.start
            while (i < ln && cur <= seg[i][1]) {
                // 找到大于 seg[i].end >= cur.start 的最小 start
                min = Math.min(min, seg[i][0]);
                i++;
            }

            // 已经找不到最小 start
            if (min == cur)
                break;
            cur = min;
            res++;
        }
        if (cur != 0)
            return -1;

        return res;
    }

    public static void main(String[] args) {
        Solution3 ss = new Solution3();
//        int[][] clips = {
//                {0, 1},
//                {1, 2}
//        };
//        int T;
//        T = 10;
//        System.out.println(ss.videoStitching(clips, T));

        int[][] clips = {
                {0, 2},
                {4, 6},
                {8, 10},
                {1, 9},
                {1, 5},
                {5, 9},
        };
        int T;
        T = 10;
        System.out.println(ss.videoStitching(clips, T));

//        int[][] clips = {
//                {0, 1},
//                {6, 8},
//                {0, 2},
//                {5, 6},
//                {0, 4},
//                {0, 3},
//                {6, 7},
//                {1, 3},
//                {4, 7},
//                {1, 4},
//                {2, 5},
//                {2, 6},
//                {3, 4},
//                {4, 5},
//                {5, 7},
//                {6, 9},
//        };
//        int T;
//        T = 7;
//        System.out.println(ss.videoStitching(clips, T));

    }
}
