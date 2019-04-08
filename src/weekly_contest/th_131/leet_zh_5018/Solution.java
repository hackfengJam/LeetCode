package weekly_contest.th_131.leet_zh_5018;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*
    *
    * class Solution {
        public:
            vector<bool> camelMatch(vector<string>& queries, string pattern) {
                vector<bool> ret;
                int n = pattern.size();
                for (auto s : queries)
                {
                    int i = 0;
                    string t;
                    for (auto c : s)
                    {
                        if (i < n && c == pattern[i])
                            ++ i;
                        else
                            t += c;
                    }
                    int flag = 0;
                    if (i != n) flag = 1;
                    for (auto c : t)
                        if (isupper(c)) flag = 1;
                    ret.push_back(!flag);
                }
                return ret;
            }
        };
    * */
    private boolean match(String query, String pattern) {
        int j = 0;
        for (int i = 0; i < query.length(); i++) {
            char c = query.charAt(i);
            if (j == pattern.length()) {
                if (c >= 'A' && c <= 'Z') {
                    return false;
                } else continue;
            }
            char pc = pattern.charAt(j);
            if (c >= 'A' && c <= 'Z') {
                if (c != pc) return false;
                else {
                    j++;
                    continue;
                }
            }
            if (c >= 'a' && c <= 'z') {
                if (c == pc) j++;
            }
        }
        return j == pattern.length();
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (String query : queries) {
            ans.add(match(query, pattern));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        List<Boolean> res;
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";
        res = ss.camelMatch(queries, pattern);
        for (Boolean bo : res)
            System.out.print(bo + " ");
    }
}
