/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 * 
 * 
 * A sudoku puzzle...
 */

public class SudokuSolverDFS {
    private static final int N = 9;
    public void solveSudoku(char[][] board) {
        searchSudokuSolu(board, 0);
    }
    
    private boolean searchSudokuSolu(char[][] board, int loca) {
        if (loca == N * N)
            return true;
            
        int row = loca / N;
        int col = loca % N;
        
        if (board[row][col] != '.')
            return searchSudokuSolu(board, loca + 1);
            
        for (char ch = '1'; ch <= '9'; ch++) {
            board[row][col] = ch;
            if (isValidSudoku(board, row, col) && searchSudokuSolu(board, loca + 1))
                return true;
            board[row][col] = '.';
        }
        return false;
    }
    
    private boolean isValidSudoku(char[][] board, int row, int col) {
        for (int i = 0; i < N; i++) {
            if (i != col && board[row][i] == board[row][col])
                return false;
        }

        for (int i = 0; i < N; i++) {
            if (i != row && board[row][col] == board[i][col])
                return false;
        }

        int rowStart = 3 * (row / 3);
        int colStart = 3 * (col / 3);
        for (int rowInc = 0; rowInc < 3; rowInc++) {
            for (int colInc = 0; colInc < 3; colInc++) {
                int newRow = rowStart + rowInc;
                int newCol = colStart + colInc;
                if ((newRow != row || newCol != col)
                        && board[row][col] == board[newRow][newCol])
                    return false;
            }
        }
        return true;
    }
}