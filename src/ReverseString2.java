/**
 * Reverse String II
 *
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the
 * start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but
 * greater than or equal to k characters, then reverse the first k characters and left the other as original.
 *
 * e.g. IN: s = "abcdefg", k = 2, OUT: "bacdfeg"
 *
 * Note:
 * The string consists of lower English letters only. Length of the given string and k will in the range [1, 10000]
 */

public class ReverseString2 {
    public static void main(String[] args){
        System.out.println(new ReverseString2().reverseStr("abcdefg", 2));
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i += 2*k) {
            reverse(chars, i, k);
        }
        return new String(chars);
    }

    private void reverse(char[] arr, int left, int k) {
        int right = left + k - 1;

        if (right >= arr.length) { right = arr.length-1; }

        while (left < right){
            char tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }
    }
}

// Long-form of above
//        while (left < right){
//            char tmp = arr[left];
//            arr[left] = arr[right];
//            arr[right] = tmp;
//            left++;
//            right--;
//        }
