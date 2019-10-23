
/**
 * Intersection of Two Arrays II
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * e.g.
 * IN: nums1 = [1,2,2,1], nums2 = [2,2], OUT: [2,2]
 * IN: nums1 = [4,9,5], nums2 = [9,4,9,8,4], OUT: [4,9]
 *
 * Note: Each element in the result should appear as many times as it shows in both arrays. The result can be in any order.
 *
 * Complexity: O(nlogn + mlogm) time where n and m are the lengths of the arrays & O(1) space via in-place operations
 * *** Note: If there was no need to sort the arrays, time complexity would be linear ***
 */

import java.util.Arrays;

public class IntersectArrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) { i++; }

            else if (nums1[i] > nums2[j]) { j++; }

            else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        int[] n1 = {1,2,2,1};
        int[] n2 = {2,2};
        new IntersectArrays2().intersect(n1, n2);
    }
}

/**
 Alternative approach
 Complexity: O(n+m) time where n and m are array lengths and O(min(n,m)) space for the hashmap of the smaller array

 import java.util.Arrays;
 import java.util.HashMap;

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) { return intersect(nums2, nums1); }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int k = 0;

        for (int num: nums2) {
            int count = map.getOrDefault(num, 0);

            if (count > 0) {
                nums1[k++] = num;
                map.put(num, count - 1);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]+ " ");
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
 */