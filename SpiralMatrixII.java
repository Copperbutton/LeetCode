/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5
 * ] ]
 */

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int startRow = 0, endRow = n - 1;
        int startCol = 0, endCol = n - 1;
        int count = 1;
        while (count <= n * n) {
            for (int col = startCol; col <= endCol; col++) {
                result[startRow][col] = count;
                count++;
            }
            startRow++;

            for (int row = startRow; row <= endRow; row++) {
                result[row][endCol] = count;
                count++;
            }
            endCol--;

            for (int col = endCol; col >= startCol; col--) {
                result[endRow][col] = count;
                count++;
            }
            endRow--;

            for (int row = endRow; row >= startRow; row--) {
                result[row][startCol] = count;
                count++;
            }
            startCol++;
        }
        return result;
    }
}