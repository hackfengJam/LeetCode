package weekly_contest.th_131.leet_zh_5019;

import java.util.Arrays;

public class Solution {
    //    public int videoStitching(int[][] clips, int T) {
//        Arrays.sort(clips, (a, b) -> b[1] - a[1] != 0 ? b[1] - a[1] : (b[1] - b[0]) - (a[1] - a[0]));
//        int res = 0;
//        int start = -1;
//        int[] clipPre = new int[2];
//        for (int i = 0; i < clips.length; i++) {
//            int[] clip = clips[i];
//            if (start == -1) {
//                if (clip[1] < T)
//                    return -1;
//
//                start = clip[0];
//                clipPre = clip;
//                res++;
//            } else {
//                if (clipPre[0] > clip[1])
//                    return -1;
//                if (clip[0] < start) {
//                    start = clip[0];
//                    clipPre = clip;
//                    res++;
//                }
//            }
//        }
//        if (clipPre[0] != 0)
//            return -1;
//
//        return res;
//    }
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (a, b) -> b[1] - a[1] != 0 ? b[1] - a[1] : (b[1] - b[0]) - (a[1] - a[0]));
        int[][] ans = new int[clips.length][2];
        int res = 0;
        int k = -1;
        int start = 0;
        for (int i = 0; i < clips.length; i++) {
            int[] clip = clips[i];
            if (k == -1) {
                if (clip[1] < T)
                    return -1;
                start = clip[0];
                ans[++k] = clip;
                res++;
            } else {
                int[] clipPre = ans[k];
                if (clipPre[0] > clip[1])
                    return -1;
                if (clip[0] < start) {
                    start = clip[0];
                    ans[++k] = clip;
                    res++;
                }
            }
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + "," + ans[i][1]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
//        int[][] clips = {
//                {0, 2},
//                {4, 6},
//                {8, 10},
//                {1, 9},
//                {1, 5},
//                {5, 9},
//        };
//        int T;
//        T = 10;
//        System.out.println(ss.videoStitching(clips, T));
        int[][] clips = {
                {0, 1},
                {6, 8},
                {0, 2},
                {5, 6},
                {0, 4},
                {0, 3},
                {6, 7},
                {1, 3},
                {4, 7},
                {1, 4},
                {2, 5},
                {2, 6},
                {3, 4},
                {4, 5},
                {5, 7},
                {6, 9},
        };
        int T;
        T = 9;
        System.out.println(ss.videoStitching(clips, T));

    }
}
