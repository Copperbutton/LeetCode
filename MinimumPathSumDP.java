/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSumDP {
    public int minPathSum(int[][] grid) {
        int ROW_NUM = grid.length;
        if (ROW_NUM == 0)
            return 0;
        int COL_NUM = grid[0].length;
        int[][] minPath = new int[ROW_NUM + 1][COL_NUM + 1];
        for (int row = 0; row < ROW_NUM - 1; row++)
            minPath[row][COL_NUM] = Integer.MAX_VALUE;
        minPath[ROW_NUM - 1][COL_NUM] = 0;

        for (int col = 0; col < COL_NUM - 1; col++)
            minPath[ROW_NUM][col] = Integer.MAX_VALUE;
        minPath[ROW_NUM][COL_NUM - 1] = 0;

        for (int row = ROW_NUM - 1; row >= 0; row--) {
            for (int col = COL_NUM - 1; col >= 0; col--) {
                minPath[row][col] = grid[row][col]
                        + Math.min(minPath[row][col + 1], minPath[row + 1][col]);
            }
        }
        return minPath[0][0];
    }
}