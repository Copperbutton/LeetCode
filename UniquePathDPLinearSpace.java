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

public class UniquePathDPLinearSpace {
    public int uniquePaths(int m, int n) {
        int[] pathSum = new int[n];
        pathSum[n - 1] = 1;
        for (int i = 0; i < m; i++)
            for (int j = n - 2; j >= 0; j--)
                pathSum[j] = pathSum[j + 1] + pathSum[j];

        return pathSum[0];
    }
}