/**
 * Maximum Subarray
 *
 * Given an integer array, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * e.g.
 * IN: [-2,1,-3,4,-1,2,1,-5,4]      OUT: 6               // [4,-1,2,1] has the largest sum of 6
 *
 * Complexity: O(n) time and O(1) space
 */

public class MaxSumSubarray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaxSumSubarray().maxSumSubarray(arr));
    }

    public int maxSumSubarray(int[] nums) {
        if (nums.length == 0 || nums == null)   return 0;

        int currSum = nums[0], maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
