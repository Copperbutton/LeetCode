/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSumDPMemo {
    private int[][] minPath;

    public int minPathSum(int[][] grid) {
        int ROW_NUM = grid.length;
        if (ROW_NUM == 0)
            return 0;
        int COL_NUM = grid[0].length;
        minPath = new int[ROW_NUM][COL_NUM];
        for (int i = 0; i < ROW_NUM; i++) {
            for (int j = 0; j < COL_NUM; j++) {
                minPath[i][j] = -1;
            }
        }
        findMinPathSum(grid, 0, 0);
        return minPath[0][0];
    }

    private int findMinPathSum(int[][] grid, int row, int col) {
        if (row == grid.length && col == grid[0].length - 1) {
            minPath[row][col] = grid[row][col];
            return minPath[row][col];
        }

        if (minPath[row][col] < 0) {
            minPath[row][col] = grid[row][col];
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            if (row < grid.length - 1)
                left = findMinPathSum(grid, row + 1, col);
            if (col < grid[0].length - 1)
                right = findMinPathSum(grid, row, col + 1);
            minPath[row][col] += Math.min(left, right);
        }
        return minPath[row][col];
    }
}