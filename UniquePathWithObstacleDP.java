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
public class UniquePathWithObstacleDP {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int ROW_NUM = obstacleGrid.length;
        if (ROW_NUM == 0)
            return 0;
        int COL_NUM = obstacleGrid[0].length;
        if (COL_NUM == 0)
            return 0;

        int[] path = new int[COL_NUM];
        path[COL_NUM - 1] = obstacleGrid[ROW_NUM - 1][COL_NUM - 1] == 0 ? 1 : 0;
        for (int i = ROW_NUM - 1; i >= 0; i--)
            for (int j = COL_NUM - 1; j >= 0; j--)
                path[j] = obstacleGrid[i][j] == 1 ? 0 : (j == COL_NUM - 1 ? 0 : path[j + 1]) + path[j];

        return path[0];
    }
}