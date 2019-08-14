/**
 * Remove Duplicates from Sorted Array II
 *
 * Given a sorted array, nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * e.g. nums = [0,0,1,1,1,1,2,3,3] will return 7 (length of [0, 0, 1, 1, 2, 3, 3])
 *
 * O(n) time and O(1) space
 */

public class RemoveKDuplicates {

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,1,2,3,3};
        System.out.println(new RemoveKDuplicates().removeDuplicates(arr));
    }

    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i : nums)
            if (count < 2 || i > nums[count - 2])
                nums[count++] = i;
        return count;
    }

}
