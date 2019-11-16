/**
 * 3Sum Smaller
 *
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target
 *
 * e.g.
 * IN: nums = [3,5,2,8,1], and target = 7       OUT: 1         // only one triplet which has a sum less than the target, 7
 * IN: nums = [-2,0,1,3], and target = 2        OUT: 2      // there are two triplets which has a sum less than 2, [-2,0,1] and [-2,0,3]
 *
 * Complexity: O(n^2) time and O(1) space
 */

import java.util.Arrays;

public class ThreeSumSmaller {

    private int twoSumSmaller(int[] nums, int start, int target) {
        int sum = 0;
        int left = start;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] < target) {
                sum += right - left;
                System.out.println("sum " + sum);
                left++;
            } else { right--; }
        }
        return sum;
    }

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length-2; i++) {
            sum += twoSumSmaller(nums, i + 1, target-nums[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,2,8,1};
        System.out.print(new ThreeSumSmaller().threeSumSmaller(arr, 7));
    }
}
