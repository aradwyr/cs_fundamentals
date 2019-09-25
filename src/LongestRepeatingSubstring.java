import java.util.HashSet;
import java.util.Set;

/**
 * Longest Repeating Substring aka Rabin-Karp algorithm
 *
 * Given a string S, find out the length of the longest repeating substring(s), return 0 if none exist.
 *
 * Constraints:
 * 1 <= S.length <= 1500
 * string S consists of only lowercase English letters from 'a' - 'z'
 *
 * e.g. IN: "aabcaabdaab"  OUT: 3 => Explanation: The longest repeating substring is "aab", which occurs 3 times.
 *
 * e.g. IN: "abbaba" OUT: 2 => Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.
 *
 * e.g. IN: "aaaaa" OUT: 4 => The longest repeating substring is "aaaa", which occurs twice.
 *
 * Big Picture Context: Seeking out repeated sequences in data is especially important for establishing causality &
 * also important for cryptography/encryption (i.e. searching for repeating/"known" header info), DNA genetic info, etc.
 *
 * Complexity: O(nlogn) time ==> O(logn) for binary search & O(n) for Rabin-Karp
 *
 * Strategy: In order to avoid manipulating very large hash values, all math is done in modulo
 *
 */

public class LongestRepeatingSubstring {

    public int longestRepeatingSubstring(String S) {
        int[] nums = new int[S.length()];

        for (int i=0; i < S.length(); i++){
            nums[i] = (int)S.charAt(i) + (int)'a';          //convert string S to array of ints
        }

        //binary search
        int left = 1, right = S.length();
        while (left <= right) {
            int m = (right-left)/2 + left;

            if (search(nums, m)){
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return left - 1;
    }

    public boolean search(int[] nums, int L){
        long MODULUS = (long) Math.pow(2, 24);          // to avoid overflow in the hash function
        long hash = 0;
        int base = 26;

        for (int i = 0; i < L; ++i) {
            hash = (hash * base + nums[i]) % MODULUS;
        }

        long baseL = 1;
        for (int i = 0; i < L; i++){
            baseL = baseL * base % MODULUS;
        }

        Set<Long> seen = new HashSet<>();
        seen.add(hash);

        for (int i = 0; i < nums.length - L; i++){
            hash = (hash * base - nums[i] * baseL % MODULUS + MODULUS) % MODULUS;

            hash = (hash + nums[i + L]) % MODULUS;

            if (!seen.add(hash)) return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(new LongestRepeatingSubstring().longestRepeatingSubstring("abbaba"));
    }

}
