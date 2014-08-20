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

public class UniquePathMemo {
    int[][] memo = null;

    public int uniquePaths(int m, int n) {
        memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                memo[i][j] = -1;

        return findUniquePaths(m, n);
    }

    private int findUniquePaths(int m, int n) {
        if (m <= 0 || n <= 0)
            return 0;
        if (m == 1 || n == 1)
            return 1;
        if (memo[m][n] < 0)
            memo[m][n] = findUniquePaths(m - 1, n) + findUniquePaths(m, n - 1);
        return memo[m][n];
    }
}