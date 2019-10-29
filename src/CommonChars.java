/**
 * Find Common Characters
 *
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all
 * strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but
 * not 4 times, you need to include that character three times in the final answer.
 *
 * You may return the answer in any order.
 *
 * e.g.
 * IN: ["bella","label","roller"]       OUT: ["e","l","l"]
 * IN: ["cool","lock","cook"]           OUT: ["c","o"]
 */

import java.util.ArrayList;
import java.util.List;

public class CommonChars {
    public static void main(String[] args) {
        String[] s = {"bella","label","roller"};
        String[] s2 = {"cool","lock","cook"};
        System.out.println(new CommonChars().commonChars(s));
        System.out.println(new CommonChars().commonChars(s2));
    }

    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<String>();
        int[] min = new int[26];

        for (int i = 0; i < 26; i++) { min[i] = Integer.MAX_VALUE; }

        for (String s : words) {
            int[] curr = new int[26];

            for (char c : s.toCharArray()) {
                curr[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                min[i] = Math.min(min[i], curr[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < min[i]; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
   }
}
