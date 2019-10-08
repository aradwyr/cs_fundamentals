/**
 * Reverse Vowels of a String
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * e.g. IN: "hello", OUT: "holle"
 * IN: "leetcode", OUT: "leotcede"
 *
 * Note: The vowels does not include the letter "y".
 */

class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(new ReverseVowels().reverseVowels("hello"));
    }

    public boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;

        while (start < end) {
            if (!isVowel(chars[start])) { start++; }

            if (!isVowel(chars[end])) { end--; }

            if (isVowel(chars[start]) && isVowel(chars[end])) {
                swap(chars, start, end);
                start++;
                end--;
            }
        }
        return new String(chars);
    }

    public void swap(char[] c, int i, int j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
    }
}
