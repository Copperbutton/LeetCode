/**
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example, There is one obstacle in the middle of a 3x3 grid as illustrated
 * below.
 * 
 * [ [0,0,0], [0,1,0], [0,0,0] ] The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 */

public class UniquePathWithObstacleMemo {
    private int[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int ROW_NUM = obstacleGrid.length;
        if (ROW_NUM == 0)
            return 0;
        int COL_NUM = obstacleGrid[0].length;
        if (COL_NUM == 0)
            return 0;

        memo = new int[ROW_NUM + 1][COL_NUM + 1];
        for (int i = 0; i < ROW_NUM + 1; i++)
            for (int j = 0; j < COL_NUM + 1; j++)
                memo[i][j] = -1;
        memo[ROW_NUM - 1][COL_NUM - 1] = 1;
        return findUniquePathsWithObstacles(obstacleGrid, 0, 0, ROW_NUM,
                COL_NUM);
    }

    private int findUniquePathsWithObstacles(int[][] obstacleGrid, int row,
            int col, int ROW, int COL) {
        if (row == ROW || col == COL)
            return 0;

        if (obstacleGrid[row][col] == 1)
            return 0;

        if (memo[row][col] < 0)
            memo[row][col] = findUniquePathsWithObstacles(obstacleGrid,
                    row + 1, col, ROW, COL)
                    + findUniquePathsWithObstacles(obstacleGrid, row, col + 1,
                            ROW, COL);
        return memo[row][col];
    }
}