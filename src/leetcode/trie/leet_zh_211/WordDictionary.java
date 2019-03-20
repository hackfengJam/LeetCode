package leetcode.trie.leet_zh_211;

import java.util.Map;
import java.util.TreeMap;

class WordDictionary {
    /*
    * 执行用时 : 267 ms
    * 内存消耗 : 95.7 MB
    * node 子节点数可以是任何字符
    * */
    public class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {

        return search(root, word, 0);
    }

    public boolean search(Node node, String word, int index) {
        Node cur = node;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c != '.') {
                if (cur.next.get(c) == null) {
                    return false;
                }
                cur = cur.next.get(c); // 可以写成递归 return search(cur.next.get(c), word, i + 1);
            } else {
                if (cur == null) {
                    return false;
                }
                for (char tc : cur.next.keySet()) {
                    if (search(cur.next.get(tc), word, i + 1)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return cur.isWord;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
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
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */