/**
 * Minimum Window Substring
 *
 * <p>Given string S and string T, find a minimum window in S which will contain all characters in T
 * in O(n) complexity.
 *
 * <p>e.g. S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 *
 * <p>Note: If there is no such window in S that covers all characters in T, return the empty string "".
 *
 * <p>If there are multiple such windows, you are guaranteed that there will always be only one
 * unique minimum window in S.
 *
 * <p>Solution O(n). Sliding window substring using two pointers.
 */

public class MinWindowSubstring {
    public static void main(String[] args) {
        System.out.println(new MinWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        int[] map = new int[128];

        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0, right = 0, minLeft = 0, minLength = Integer.MAX_VALUE, counter = t.length();

        while (right < s.length()) {
            final char c1 = s.charAt(right);

            if (map[c1] > 0) counter--;

            map[c1]--;
            right++;

            while (counter == 0) {
                if (minLength > right - left) {
                    minLength = right - left;
                    minLeft = left;
                }

                final char c2 = s.charAt(left);
                map[c2]++;

                if (map[c2] > 0) counter++;
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}
