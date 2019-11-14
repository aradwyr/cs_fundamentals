/**
 * Longest Consecutive Sequence
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 *
 * e.g.
 * IN:  [100, 4, 200, 1, 3, 2]      OUT: 4      // longest consecutive elements sequence is [1, 2, 3, 4] with a length of 4.
 *
 * Complexity: O(n) time and space
 */

import java.util.HashSet;
import java.util.Set;

public class LongestConsecSeq {
    public int longestSequenceLength(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int num : nums) { set.add(num); }

        int longestStreak = 0;

        for (int s : set) {
            if (!set.contains(s - 1)) {
                int currNum = s;
                int currStreak = 1;

                while (set.contains(currNum + 1)) {
                    currNum += 1;
                    currStreak += 1;
                }
                longestStreak = Math.max(currStreak, longestStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecSeq().longestSequenceLength(arr));
    }
}
