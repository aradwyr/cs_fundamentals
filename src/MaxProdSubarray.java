/**
 * Maximum Product Subarray
 *
 * Given an integer array, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * e.g.
 * IN: [2, 3, -2, 4]       OUT: 6                      // [2,3] has the largest product 6
 * IN: [-2, 0, -1]         OUT: 0                      // cannot be 2 since [-2,-1] is not a contiguous subarray
 * IN: [-2, 3, -4]         OUT: 24
 *
 * Complexity: O(n) time and O(1) space
 *
 * tags: dynamic programming, greedy
 */

public class MaxProdSubarray {
    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        int[] arr2 = {-2, 0, -1};
        int[] arr3 = {-4, -3, -2};
        int[] arr4 = {3, 2, -1,  5, -2};
        System.out.println(new MaxProdSubarray().maxProductSubarray(arr));
        System.out.println(new MaxProdSubarray().maxProductSubarray(arr2));
        System.out.println(new MaxProdSubarray().maxProductSubarray(arr3));
        System.out.println(new MaxProdSubarray().maxProductSubarray(arr4));
    }

    public int maxProductSubarray(int[] nums) {
        if (nums.length == 0 || nums == null)   return 0;

        int min = nums[0], max = nums[0], maxProd = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < 0) {                       // if neg value then swap min and max
                int temp = min;
                min = max;
                max = temp;
            }

            max = Math.max(nums[i], nums[i] * max);
            min = Math.min(nums[i], nums[i] * min);
            maxProd = Math.max(max, maxProd);
        }
        return maxProd;
    }
}
