/**
 * Replace Words
 *
 * In English, we have a concept called root, which can be followed by some other words to form another longer word -
 * let's call this word successor. For example, the root an, followed by other, which can form another word another.
 *
 * Given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence
 * with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
 *
 * You need to output the sentence after the replacement.
 *
 * e.g.
 * IN: dict = ["cat", "bat", "rat"], sentence = "the cattle was rattled by the battery"
 * OUT: "the cat was rat by the bat"
 *
 * Note: The input will only have lower-case letters.
 *
 * Complexity:
 * O(n) time, where n is sentence length
 * O(n) space, where n is the size of the trie
 */

import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {

    public static class TrieNode {
        TrieNode[] links;
        String word;

        TrieNode() {
            links = new TrieNode[26];
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        TrieNode t = new TrieNode();

        for (String d : dict) {
            TrieNode curr = t;
            for (char c : d.toCharArray()) {
                if (curr.links[c - 'a'] == null) { curr.links[c - 'a'] = new TrieNode(); }

                curr = curr.links[c - 'a'];
            }
            curr.word = d;
        }

        StringBuilder res = new StringBuilder();
        for (String w : sentence.split("\\s+")) {
            if (res.length() > 0) { res.append(" "); }

            TrieNode curr = t;
            for (char c : w.toCharArray()) {
                if (curr.links[c - 'a'] == null || curr.word != null) { break; }

                curr = curr.links[c - 'a'];
            }
            res.append(curr.word != null ? curr.word : w);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() {{
            add("cat");
            add("bat");
            add("rat");
        }};
        System.out.print(new ReplaceWords().replaceWords(list, "the cattle was rattled by the battery"));
    }
}
