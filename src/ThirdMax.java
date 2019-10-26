/**
 * Third Maximum Number
 *
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number.
 * Note: The time complexity must be in O(n).
 *
 * e.g.
 * IN: [3, 1, 2]        OUT: 1
 * IN: [1, 2]           OUT: 2          The third maximum does not exist, so the maximum (2) is returned instead.
 * IN: [2, 2, 3, 1]     OUT: 1          Note that the third maximum here means the third maximum distinct number.
 */

public class ThirdMax {

    public static void main(String[] args){
        int[] arr = {2, 2, 3, 1};
        System.out.println(new ThirdMax().thirdMax(arr));
    }

    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        for (Integer num : nums) {
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) { continue; }

            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null || num > max3) {
                max3 = num;
            }
        }
        return (max3 == null) ? max1 : max3;
    }
}
