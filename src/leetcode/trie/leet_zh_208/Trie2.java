package leetcode.trie.leet_zh_208;

import java.util.TreeMap;

class Trie2 {
    /*
     * 执行用时 : 181 ms
     * 内存消耗 : 69.8 MB
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
    public Trie2() {
        root = new Node();
    }

    private int toIndex(char c) {
        return c - 'a';
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

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
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next[toIndex(c)] == null) {
                return false;
            }
            cur = cur.next[toIndex(c)];
        }
        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next[toIndex(c)] == null) {
                return false;
            }
            cur = cur.next[toIndex(c)];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie2 trie = new Trie2();
        trie.insert("apple");
        System.out.println(trie.search("app"));
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("apple"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */