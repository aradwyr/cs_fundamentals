/**
 * Word Break II
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to
 * construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 *
 * Note: The same word in the dictionary may be reused multiple times in the segmentation. Assume the dictionary does not contain duplicate words.
 *
 * e.g.
 * IN: s = "catsanddog"   wordDict = ["cat", "cats", "and", "sand", "dog"]                       OUT: [ "cats and dog", "cat sand dog" ]
 * IN: s = "pineapplepenapple"  wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]     OUT: [ "pine apple pen apple", "pineapple pen apple", "pine applepen apple" ]
 * IN: s = "catsandog"  wordDict = ["cats", "dog", "sand", "and", "cat"]                         OUT: []
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        System.out.println(new WordBreak().wordBreak("catsanddog", dict));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) { return new ArrayList<>(); }

        List<String> res = new ArrayList<>();
        boolean[] memo = new boolean[s.length()];
        Arrays.fill(memo, true);
        dfs(s, wordDict, res, new StringBuilder(), memo, 0);
        return res;
    }

    private void dfs(String s, List<String> wordDict, List<String> res, StringBuilder sb, boolean[] memo, int index) {
        if (index == s.length()) {              // base case
            res.add(sb.toString());
            return;
        }

        if (!memo[index]) { return; }

        int resSize = res.size();
        int sbLen = sb.length();

        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);

            if (wordDict.contains(str)) {
                if (sb.length() == 0) { sb.append(str); }
                else {
                    sb.append(" " + str);
                }

                dfs(s, wordDict, res, sb, memo, i + 1);
                sb.setLength(sbLen);
            }
        }

        if (resSize == res.size()) { memo[index] = false; }          // if result size unchanged
    }
}
