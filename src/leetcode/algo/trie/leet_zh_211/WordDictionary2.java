package leetcode.algo.trie.leet_zh_211;

class WordDictionary2 {
    /*
     * 执行用时 : 176 ms
     * 内存消耗 : 61.3 MB
     * 针对本题，将 node 子节点数写死
     * */
    public class Node {
        public boolean isWord;
        public Node[] next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new Node[26];
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary2() {
        root = new Node();
    }

    private int toIndex(char c) {
        return c - 'a';
    }

    /**
     * Inserts a word into the trie.
     */
    public void addWord(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next[toIndex(c)] == null) {
                cur.next[toIndex(c)] = new Node();
            }
            cur = cur.next[toIndex(c)];
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {

        return search(root, word, 0);
    }

    public boolean search(Node node, String word, int index) {
        Node cur = node;
        if (cur == null) {
            return false;
        }
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c != '.') {
                if (cur.next[toIndex(c)] == null) {
                    return false;
                }
                cur = cur.next[toIndex(c)]; // 可以写成递归 return search(cur.next.get(c), word, i + 1);
            } else {
                for (int j = 0; j < cur.next.length; j++) {
                    if (search(cur.next[j], word, i + 1)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return cur.isWord;
    }


    public static void main(String[] args) {
        WordDictionary2 wordDictionary = new WordDictionary2();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
        System.out.println(wordDictionary.search("."));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */