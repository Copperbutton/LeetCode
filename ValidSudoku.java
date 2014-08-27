/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * 
 * A partially filled sudoku which is valid.
 * 
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 */

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] used = new boolean[9];
        for (int row = 0; row < 9; row++) {
            Arrays.fill(used, false);
            for (int col = 0; col < 9; col++) {
                char ch = board[row][col];
                if (!isValidCell(used, ch))
                    return false;
            }
        }

        for (int col = 0; col < 9; col++) {
            Arrays.fill(used, false);
            for (int row = 0; row < 9; row++) {
                char ch = board[row][col];
                if (!isValidCell(used, ch))
                    return false;
            }
        }

        for (int rowBase = 0; rowBase < 3; rowBase++) {
            for (int colBase = 0; colBase < 3; colBase++) {
                Arrays.fill(used, false);
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        char ch = board[rowBase * 3 + row][colBase * 3 + col];
                        if (!isValidCell(used, ch))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValidCell(boolean[] used, char ch) {
        if (ch == '.')
            return true;

        int valueOfCh = ch - '1';
        if (used[valueOfCh])
            return false;
        used[valueOfCh] = true;
        return true;
    }
}