package leetcode.algo.union_find.leet_zh_547;

public class SolutionUF {
    /*
     * 执行用时 : 16 ms
     * 内存消耗 : 50.5 MB
     * 未优化的并查集
     * */
    public class UnionFind {
        private int[] parent;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        private int find(int p) {
            if (p < 0 && p >= parent.length) {
                throw new IllegalArgumentException("p is out of bound");
            }
            return parent[p];
        }

        public int UnionElements(int p, int q) {
            int pParent = find(p);
            int qParent = find(q);

            if (pParent == qParent) {
                return 0;
            }

            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == pParent) {
                    parent[i] = qParent;
                }
            }
            return 1;
        }
    }

    private UnionFind unionFind;

    public int findCircleNum(int[][] M) {
        unionFind = new UnionFind(M.length);
        int[] line;
        int cnt = M.length;
        for (int i = 0; i < M.length; i++) {
            line = M[i];
            for (int j = 0; j < line.length; j++) {
                if (M[i][j] == 1) {
                    cnt -= unionFind.UnionElements(i, j);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
//        int[][] M = {
//                {1, 1, 0},
//                {1, 1, 0},
//                {0, 0, 1}};
        int[][] M = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}};
        System.out.println(new SolutionUF().findCircleNum(M));
    }

}
