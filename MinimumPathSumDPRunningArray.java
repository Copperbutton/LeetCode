/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSumDPRunningArray {
    public int minPathSum(int[][] grid) {
        int ROW_NUM = grid.length;
        if (ROW_NUM == 0)
            return 0;
        int COL_NUM = grid[0].length;
        int[] minPath = new int[COL_NUM + 1];
        Arrays.fill(minPath, Integer.MAX_VALUE);
        minPath[COL_NUM - 1] = 0;
        for (int row = ROW_NUM - 1; row >= 0; row --) {
            for (int col = COL_NUM - 1; col >= 0; col --) {
                minPath[col] = grid[row][col] + Math.min(minPath[col], minPath[col + 1]);
            }
        }
        return minPath[0];
    }
}