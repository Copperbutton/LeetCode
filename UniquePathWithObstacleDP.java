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
        int ROW = obstacleGrid.length;
        if (ROW == 0)
            return 0;
        int COL = obstacleGrid[0].length;
        int[] path = new int[COL + 1];
        path[COL - 1] = obstacleGrid[ROW - 1][COL - 1] == 1 ? 0 : 1;
        for (int row = ROW - 1; row >= 0; row--) {
            for (int col = COL - 1; col >= 0; col --) {
                path[col] = obstacleGrid[row][col] == 1 ? 0 : path[col] + path[col + 1];
            }
        }
        return path[0];
    }
}