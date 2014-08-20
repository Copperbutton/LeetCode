/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 */

public class UniquePathDP {
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1)
            return 0;

        if (m == 1 || n == 1)
            return 1;

        int[][] path = new int[m][n];
        path[m - 1][n - 1] = 0;
        for (int row = 0; row < m - 1; row++)
            path[row][n - 1] = 1;

        for (int col = 0; col < n - 1; col++)
            path[m - 1][col] = 1;

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                path[row][col] = path[row + 1][col] + path[row][col + 1];
            }
        }
        return path[0][0];
    }
}