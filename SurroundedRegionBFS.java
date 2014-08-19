/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class Solution {
    public void solve(char[][] board) {
        int ROW_NUM = board.length;
        if (ROW_NUM <= 2)
            return;
        int COL_NUM = board[0].length;
        if (COL_NUM <= 2)
            return;
        
        char MARKER = 'Y';
        for (int col = 0; col < COL_NUM; col++) {
            if (board[0][col] == 'O')
                searchAndMarkRegion(board, 0, col, MARKER);
            if (board[ROW_NUM - 1][col] == 'O')
                searchAndMarkRegion(board, ROW_NUM - 1, col, MARKER);
        }
        
        for (int row = 1; row < ROW_NUM - 1; row++) {
            if (board[row][0] == 'O')
                searchAndMarkRegion(board, row, 0, MARKER);
            if (board[row][COL_NUM - 1] == 'O')
                searchAndMarkRegion(board, row, COL_NUM - 1, MARKER);
        }
        
        for (int row = 0; row < ROW_NUM; row++) {
            for (int col = 0; col < COL_NUM; col++) {
                if (board[row][col] == 'O')
                    board[row][col] = 'X';
                
                if (board[row][col] == MARKER)
                    board[row][col] = 'O';
            }
        }
    }
    
    private void searchAndMarkRegion(char[][] board, int startRow,
                                     int startCol, char MARKER) {
        int ROW_NUM = board.length;
        int COL_NUM = board[0].length;
        
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        List<Integer> start = genPosition(startRow, startCol);
        board[startRow][startCol] = MARKER;
        queue.offer(start);
        while (!queue.isEmpty()) {
            List<Integer> next = queue.poll();
            int row = next.get(0), col = next.get(1);
            
            if (row > 0 && board[row - 1][col] == 'O') {
                List<Integer> up = genPosition(row - 1, col);
                queue.offer(up);
                board[row - 1][col] = MARKER;
            }
            
            if (row + 1 < ROW_NUM && board[row + 1][col] == 'O') {
                List<Integer> down = genPosition(row + 1, col);
                queue.offer(down);
                board[row + 1][col] = MARKER;
            }
            
            if (col > 0 && board[row][col - 1] == 'O') {
                List<Integer> left = genPosition(row, col - 1);
                queue.offer(left);
                board[row][col - 1] = MARKER;
            }
            
            if (col + 1 < COL_NUM && board[row][col + 1] == 'O') {
                List<Integer> right = genPosition(row, col + 1);
                queue.offer(right);
                board[row][col + 1] = MARKER;
            }
        }
    }
    
    private List<Integer> genPosition(int row, int col) {
        List<Integer> position = new ArrayList<Integer>();
        position.add(row);
        position.add(col);
        return position;
    }
}