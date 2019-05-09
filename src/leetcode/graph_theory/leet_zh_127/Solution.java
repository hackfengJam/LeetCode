package leetcode.graph_theory.leet_zh_127;

import java.util.*;

public class Solution {
    /*
     * 127. 单词接龙
     *
     * 执行用时 : 580 ms, 在Word Ladder的Java提交中击败了28.96% 的用户
     * 内存消耗 : 38.6 MB, 在Word Ladder的Java提交中击败了86.28% 的用户


     【笔记】两端搜索。本题是需要从beginWord转换为endWord。上一份笔记严格按照这个要求，进行转换，结果为88ms。

        本条笔记采用两端搜索对上一份笔记进行了优化。两端搜索也就是说：“一头从beginWord转换为endWord，另外一头从endWord转换为beginWord。”为什么要这么做呢？有什么意义呢？

        举个例子：

        假设从beginWord转换为endWord，存在于字典中的，（第一个）中间结果有30个。

        而，从endWord转换为beginWord，存在于字典中的，（第一个）中间结果只有2个。

        那么，很显然。从endWord开始会更快。所以，每次都从个数少的那块开始替换一位。

        因此，我们每次都从中间结果少的那一端出发，这样就能剪枝掉很多不必要的搜索过程。

        以下优化结果16ms。

        int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
            unordered_set<string> wordDict(wordList.begin(), wordList.end());
            if (wordDict.find(endWord) == wordDict.end()){
                return 0;//Not FOUND 404
            }
            unordered_set<string> beginSet{beginWord};
            unordered_set<string> endSet{endWord};
            int step = 1;
            for (; !beginSet.empty();){
                unordered_set<string> tempSet;
                ++step;
                for (auto s : beginSet) {
                    wordDict.erase(s);
                }
                for (auto s : beginSet) {
                    for (int i = 0; i < s.size(); ++i){
                        string str = s;
                        for (char c = 'a'; c <= 'z'; ++c){
                            str[i] = c;
                            if (wordDict.find(str) == wordDict.end()){
                                continue;
                            }
                            if (endSet.find(str) != endSet.end()){
                                return step;
                            }
                            tempSet.insert(str);
                        }
                    }
                }
                if (tempSet.size() < endSet.size()){
                    beginSet = tempSet;
                } else {
                    beginSet = endSet;
                    endSet = tempSet;
                }
            }
            return 0;
        }
     * */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.indexOf(endWord) == -1) {
            return 0;
        }
        int depth = 0;
        Map<String, Boolean> map = new HashMap<>();
        boolean[] valid = new boolean[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            valid[i] = true;
        }
        map.put(beginWord, true);
        Map<String, Boolean> newMap;
        boolean isStart = false;
        while (!isStart || !map.isEmpty()) {
            isStart = true;
            newMap = new HashMap<>();
            depth++;
            for (String s : map.keySet()) {
                beginWord = s;
                if (endWord.equals(beginWord))
                    return depth;
                for (int i = 0; i < wordList.size(); i++) {
                    int dif = 0;
                    if (!valid[i])
                        continue;
                    String cur = wordList.get(i);
                    for (int j = 0; j < beginWord.length(); j++) {
                        if (cur.charAt(j) != beginWord.charAt(j))
                            dif++;
                        if (dif > 1)
                            break;
                    }
                    if (dif == 1) {
                        newMap.put(cur, true);
                        valid[i] = false;
                    }
                }
            }
            map = newMap;
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();

        String beginWord = "hit";
//        String beginWord = "hot";
        String endWord = "cog";
//        String endWord = "dog";
//        String[] strs = {"hot", "dot", "dog", "lot", "log"};
        String[] strs = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String[] strs = {"hot", "dog"};
        List<String> wordList = new ArrayList<>(Arrays.asList(strs));
        System.out.println(ss.ladderLength(beginWord, endWord, wordList));
    }
}