/**
 * Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 *
 * e.g. board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * For given word = "ABCCED", return true
 * For given word = "ABCB", return false.
 */

public class WordSearch {

    public static void main(String[] args) {
        char[][] grid = { {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'} };
        System.out.println(new WordSearch().isFound(grid, "ABCCED"));
    }

    public boolean isFound(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (lookup(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean lookup(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y < 0 || x < 0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = lookup(board, y, x+1, word, i+1)
                || lookup(board, y, x-1, word, i+1)
                || lookup(board, y+1, x, word, i+1)
                || lookup(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }
}
