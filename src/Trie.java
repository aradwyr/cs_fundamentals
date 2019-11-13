/**
 * Implement Trie (Prefix Tree)
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Note: You may assume that all inputs are consist of lowercase letters a-z. All inputs are guaranteed to be non-empty strings.
 *
 * e.g.
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 *
 * Big Picture: Tries useful in various applications like autocomplete, spell checker, IP routing (longest prefix matching), etc.
 *
 * N.B. Trie (pronounced as 'try') is a fixed tree data structure that outperforms hash tables -- hash tables do have
 * constant O(1) time complexity for key lookup but are inefficient wrt finding all keys with common prefix. Also,
 * hash tables will run into hash collisions with an increasing hash table size causing search to slow to O(n) where n is
 * number of keys. Tries can use less space compared to hash tables when storing many keys with the same prefix.
 *
 * Complexity:
 * Insert into Trie:                    O(m) (where m is key length) time and space
 * Search Trie:                         O(m) time and O(1) space
 * Search Prefix/startsWith:            O(m) time and O(1) space
 */

public class Trie {

    public static class TrieNode {
        private TrieNode[] links;
        private boolean isEnd;

        public TrieNode() { links = new TrieNode[26]; }                                             // a-z length = 26

        public boolean containsKey(char c) { return links[c - 'a'] != null; }

        public TrieNode get(char c) { return links[c - 'a']; }

        public void put(char c, TrieNode node) { links[c - 'a'] = node; }

        public void setEnd() { isEnd = true; }

        public boolean isEnd() { return isEnd; }
    }

    private TrieNode root;

    public Trie() { root = new TrieNode(); }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.search("app"));             // false
        System.out.println(t.startsWith("app"));               // true
    }

    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            if (!node.containsKey(curr)) { node.put(curr, new TrieNode()); }

            node = node.get(curr);
        }
        node.setEnd();
    }

    private TrieNode prefixSearch(String word) {                                 // search entire or partial trie
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            if (node.containsKey(curr)) { node = node.get(curr); }
            else { return null; }
        }
        return node;                                                            // returns node where search ends
    }

    public boolean search(String word) {
        TrieNode node = prefixSearch(word);
        return node != null && node.isEnd();                                    // returns true if the word is in trie
    }

    public boolean startsWith(String prefix) {
        TrieNode node = prefixSearch(prefix);
        return node != null;
    }
}
