package weekly_contest.th_133.leet_zh_1032;

import java.util.ArrayList;
import java.util.List;

class StreamChecker {
    /*
     *
     * 单词查找树
     * 通过
     *
     * 对于测试用例 test.txt 执行用时 : 171 ms
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
    private List<Character> queryS;

    private void insert(String key) {
        Node cur = root;
        for (int i = key.length() - 1; i >= 0; i--) {
            int c = key.charAt(i) - 'a';
            if (cur.next[c] == null) {
                cur.next[c] = new Node();
            }
            cur = cur.next[c];
        }
        cur.isWord = true;
    }

    public StreamChecker(String[] words) {
        root = new Node();
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        queryS = new ArrayList<>();
    }

    private boolean isPrefix(List<Character> prefix) {
        Node cur = root;
        for (int i = prefix.size() - 1; i >= 0 && prefix.size() - i <= 2000; i--) {
            int c = prefix.get(i) - 'a';
            if (cur.next[c] == null)
                return false;
            else {
                if (cur.next[c].isWord)
                    return true;
                cur = cur.next[c];
            }
        }
        return false;
    }

    public boolean query(char letter) {
        queryS.add(letter);
        return isPrefix(queryS);
    }

    public static void main(String[] args) {
//        int[] nums = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
//        int[] nums = {0,2,1,-6,6,7,9,-1,2,0,1};
        String[] nums = {"ab", "ba", "aaab", "abab", "baa"};

        StreamChecker streamChecker = new StreamChecker(nums);
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