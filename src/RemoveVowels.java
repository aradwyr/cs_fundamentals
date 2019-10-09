/**
 * Remove Vowels from a String
 *
 * Given a string s, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return a new string.
 *
 * e.g. IN: "aeiou", OUT: ""
 * IN: "hello there", OUT: "hll thr"
 *
 */

import java.util.HashSet;
import java.util.Set;

class RemoveVowels {
    public static void main(String[] args) {
        System.out.println(new RemoveVowels().removeVowels("aeiou"));
        System.out.println(new RemoveVowels().removeVowels("hello there"));
    }

    public String removeVowels(String s) {
        if (s.length() < 1) return null;

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (!vowels.contains(chars[i])) { sb.append(chars[i]); }
        }
        return sb.toString();
    }
}
