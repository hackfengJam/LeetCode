package weekly_contest.th_133.leet_zh_1032;

import java.util.HashMap;

class StreamChecker3 {
    /*
     *
     * TST 三向单词查找树
     * TLE
     *
     * 对于测试用例 test.txt 执行用时 : 650 ms
     * */
    private static final int M = 26;

    private class Node {
        public char c;
        public int val;
        public Node left, mid, right;

        public Node(char c, int val, Node left, Node mid, Node right) {
            this.c = c;
            this.val = val;
            this.left = left;
            this.mid = mid;
            this.right = right;
        }

        public Node(char c) {
            this(c, -1, null, null, null);
        }

        public Node() {
            this('\0', -1, null, null, null);
        }
    }


    private Node root;
    private StringBuilder queryS;
    private HashMap<String, Boolean> di;

    private Node add(Node cur, String key, int val, int d) {
        char c = key.charAt(d);
        if (cur == null) {
            cur = new Node(c);
        }
        if (cur.c > c) {
            cur.left = add(cur.left, key, val, d);
        } else if (cur.c < c) {
            cur.right = add(cur.right, key, val, d);
        } else if (d < key.length() - 1) {
            cur.mid = add(cur.mid, key, val, d + 1);
        } else {
            cur.val = val;
        }
        return cur;
    }

    public void add(String key, int val) {
        root = add(root, key, val, 0);
    }

    public int get(String key) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur == null) {
                return -1;
            }
            if (c < cur.c) {
                cur = cur.left;
                i--;
            } else if (c > cur.c) {
                cur = cur.right;
                i--;
            } else {
                if (cur.val == 1 || key.length() - 1 == i)
                    return cur.val;
                if (i >= 2000)
                    return -1;
                cur = cur.mid;
            }
        }
        return cur.val;
    }

    public StreamChecker3(String[] words) {
        root = null;
        di = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            String de = "";
            for (int j = str.length() - 1; j >= 0; j--)
                de += str.charAt(j);
            add(de, 1);
            di.put(de, true);
        }
        queryS = new StringBuilder();
    }


    public boolean query(char letter) {
        queryS.insert(0, letter);
        return get(queryS.toString()) == 1;
    }

    public static void main(String[] args) {
//        int[] nums = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
//        int[] nums = {0,2,1,-6,6,7,9,-1,2,0,1};
        String[] nums = {"ab", "ba", "aaab", "abab", "baa"};

        StreamChecker3 streamChecker = new StreamChecker3(nums);
        System.out.println(streamChecker.query('a'));          // 返回 false
        System.out.println(streamChecker.query('a'));           // 返回 false
        System.out.println(streamChecker.query('a'));          // 返回 false
        System.out.println(streamChecker.query('a'));          // 返回 false
        System.out.println(streamChecker.query('a'));          // 返回 false
        System.out.println(streamChecker.query('b'));          // 返回 true
        System.out.println(streamChecker.query('a'));          // 返回 true
        System.out.println(streamChecker.query('b'));          // 返回 true
        System.out.println(streamChecker.query('a'));          // 返回 true
        System.out.println(streamChecker.query('b'));          // 返回 false
    }
}