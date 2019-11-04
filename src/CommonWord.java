/**
 * Most Common Word
 *
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation. Words in the paragraph are not case sensitive. The answer is in lowercase.
 *
 * e.g.
 * IN: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."   banned = ["hit"]     OUT: "ball"
 *
 * Complexity: O(n + m) time and space where n and m are the size of the two inputs
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommonWord {
    public static void main(String[] args) {
        String p = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banArr = {"hit"};
        System.out.print(new CommonWord().mostCommonWord(p, banArr));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String b : banned) { set.add(b); }

        Map<String, Integer> map = new HashMap<>();
        String res = "";
        int count = 0;

        for (String s : paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ")) {
            s = s.trim();
            if (s.length() == 0 || set.contains (s)) continue;

            map.put(s, map.getOrDefault(s, 0) + 1);
            if (count < map.get (s)) {
                count = map.get (s);
                res = s;
            }
        }
        return res;
    }
}
