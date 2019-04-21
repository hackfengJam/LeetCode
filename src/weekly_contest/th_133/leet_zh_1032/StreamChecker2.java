package weekly_contest.th_133.leet_zh_1032;

class StreamChecker2 {
    /*
     *
     * 单词查找树
     * TLE
     *
     * 对于测试用例 test.txt 执行用时 : 583 ms
     * */
    private static final int M = 26;

    private class Node {
        private boolean isWord;
        private Node[] next;

        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new Node[M];
        }
    }

    private Node root;
    private StringBuilder queryS;

    private int charToInt(char c) {
        return c - 'a';
    }

    private void insert(String key) {
        Node cur = root;
        for (int i = key.length() - 1; i >= 0; i--) {
            int c = charToInt(key.charAt(i));
            if (cur.next[c] == null) {
                cur.next[c] = new Node();
            }
            cur = cur.next[c];
        }
        cur.isWord = true;
    }


    public StreamChecker2(String[] words) {
        root = new Node();
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        queryS = new StringBuilder();
    }

    private boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int c = charToInt(prefix.charAt(i));
            if (cur.next[c] == null)
                return false;
            else {
                if (cur.next[c].isWord)
                    return true;
                cur = cur.next[c];
            }
            if (i >= 2000) return false;
        }
        return false;
    }

    public boolean query(char letter) {
        queryS.insert(0, letter);
        return isPrefix(queryS.toString());
    }

    public static void main(String[] args) {
//        int[] nums = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
//        int[] nums = {0,2,1,-6,6,7,9,-1,2,0,1};
        String[] nums = {"ab", "ba", "aaab", "abab", "baa"};

        StreamChecker2 streamChecker = new StreamChecker2(nums);
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