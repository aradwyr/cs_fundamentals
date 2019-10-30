/**
 * Single Element in Sorted Array
 *
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one
 * element which appears exactly once. Find this single element that appears only once.
 *
 * e.g.
 * IN: [1,1,2,3,3,4,4,8,8]      OUT: 2
 * IN: [3,3,7,7,10,11,11]       OUT: 10
 **
 * Complexity: O(logn) time and O(1) space
 */

public class singleNonDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] arr2 = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(new singleNonDuplicate().findNonDuplicate(arr));
        System.out.println(new singleNonDuplicate().findNonDuplicate(arr2));
    }

    public int findNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (hi-lo)/2 + lo;

            if (mid % 2 == 1) { mid--; }            // if mid isn't an even index value, decrement index

            if (nums[mid] == nums[mid+1]) { lo = mid + 2; }
            else { hi = mid; }
        }
        return nums[lo];
    }
}
