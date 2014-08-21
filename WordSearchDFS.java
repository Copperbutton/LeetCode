/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * [ ["ABCE"], ["SFCS"], ["ADEE"] ] word = "ABCCED", -> returns true, word =
 * "SEE", -> returns true, word = "ABCB", -> returns false.
 */

public class WordSearchDFS {
    public boolean exist(char[][] board, String word) {
        int ROW_NUM = board.length;
        if (ROW_NUM == 0)
            return false;
        int COL_NUM = board[0].length;
        if (COL_NUM == 0)
            return false;
        boolean[][] used = new boolean[ROW_NUM][COL_NUM];
        for (int row = 0; row < ROW_NUM; row++) {
            for (int col = 0; col < COL_NUM; col++) {
                if (findWord(board, used, row, col, 0, word))
                    return true;
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, boolean[][] used, int row,
            int col, int index, String word) {
        if (index == word.length())
            return true;

        if (row >= board.length || row < 0 || col >= board[0].length || col < 0)
            return false;

        if (used[row][col])
            return false;

        if (board[row][col] != word.charAt(index))
            return false;

        used[row][col] = true;
        boolean found = findWord(board, used, row + 1, col, index + 1, word)
                || findWord(board, used, row - 1, col, index + 1, word)
                || findWord(board, used, row, col + 1, index + 1, word)
                || findWord(board, used, row, col - 1, index + 1, word);
        used[row][col] = false;
        return found;
    }
}