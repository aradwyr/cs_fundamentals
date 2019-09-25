/**
 * Valid Palindrome
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * tags: strings, pointers
 */

import static java.lang.Character.toLowerCase;
import static java.lang.Character.isLetterOrDigit;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;

        while (i < j) {
            if (!isLetterOrDigit(s.charAt(i)))  i++;

            else if (!isLetterOrDigit(s.charAt(j)))  j--;

            else if (toLowerCase(s.charAt(i++)) != toLowerCase(s.charAt(j--))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
    }
}

