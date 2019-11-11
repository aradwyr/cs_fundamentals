/**
 * Two Sum
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * e.g.
 * IN: nums = [2, 7, 11, 15], target = 9        OUT: [0, 1]         // nums[0] + nums[1] = 2 + 7 = 9
 * IN: nums = [3, 2, 4], target = 6             OUT: [1, 2]
 *
 * Complexity: O(n) time and space
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] arr2 = {3, 2, 4};
        System.out.println(java.util.Arrays.toString(new TwoSum().twoSum(arr, 9)));
        System.out.println(java.util.Arrays.toString(new TwoSum().twoSum(arr2, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {                           // O(1) lookup with hash table
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);                                         // map each element in array to it's index
        }
        throw new IllegalArgumentException("No solution");
    }
}
