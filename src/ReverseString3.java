/**
 * Reverse Words in a String III
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving
 * whitespace and initial word order.
 *
 * e.g. IN: "Let's take LeetCode contest", OUT: "s'teL ekat edoCteeL tsetnoc"
 *
 * Note: Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 *
 */

public class ReverseString3 {
    public static void main(String[] args) {
        System.out.println(new ReverseString3().reverseWords("Let's do LeetCode"));
    }

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < arr.length; i++){
            sb.append(reverse(arr[i]));

            if(i != arr.length-1){ sb.append(" "); }
        }
        return sb.toString();
    }

    public String reverse(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length-1;
        while (left < right) {
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
        return new String(chars);
    }
}
