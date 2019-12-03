/**
 * Repeated DNA Sequence
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * e.g.
 * IN: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"           OUT: ["AAAAACCCCC", "CCCCCAAAAA"]
 *
 * Strategy:
 * - slice over the input string and compute the hash of the sequence in the sliding window, if hash is in the hashset
 * then there's a repeating sequence and add to output hashset
 * - basic implementation of Rabin-Karp algorithm
 *
 * Complexity: O(n) time and space where n is string length -- for completeness: O(n - L) time and space but since L = 10, complexity reduces to O(n)
 */

import java.util.*;

public class RepeatedDNASeq {
    public List<String> findRepeatingSeq(String s) {
        int L = 10, a = 4, aL = (int) Math.pow(a, L), n = s.length();                   // rolling hash is base 4

        if (n <= L) { return new ArrayList<>(); }

        Map<Character, Integer> dnaIntMap = new HashMap<>() {{ put('A', 0); put('C', 1); put('G', 2); put('T', 3); }};
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) { nums[i] = dnaIntMap.get(s.charAt(i)); }

        int h = 0;
        Set<Integer> seen = new HashSet<>();
        Set<String> output = new HashSet<>();

        for (int start = 0; start < n - L + 1; start++) {
            if (start == 0) {
                for (int i = 0; i < L ; i++) { h = h * a + nums[i]; }                  // O(L) time for initial sequence
            } else {
                h = h * a - nums[start - 1] * aL + nums[start + L - 1];                 // O(1) time hash generation
            }

            if (seen.contains(h)) { output.add(s.substring(start, start + L)); }
            seen.add(h);
        }
        return new ArrayList<String>(output);
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedDNASeq().findRepeatingSeq("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}

    /*
    Simpler solution: O(n) time and space

    public List <String> findRepeatingSequences(String s) {
        int L = 10;

        HashSet<String> seen = new HashSet<>();
        HashSet<String> output = new HashSet<>();

        for (int i = 0; i < s.length() - L + 1; i++) {
            String tmp = s.substring(i, i + L);

            if (seen.contains(tmp) { output.add(tmp); }

            seen.add(tmp);
        }
        return new ArrayList<String>(output);
    }
    */