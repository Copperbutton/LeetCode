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
        if (n < 0)
            return null;
        
        int[][] matrix = new int[n][n];
        int startR = 0, endR = n - 1;
        int startC = 0, endC = n - 1;
        int count = 1;
        while (count <= n * n) {
            for (int i = startC; i <= endC; i++)
                matrix[startR][i] = count ++;
            ++ startR;
            
            for (int i = startR; i <= endR; i++)
                matrix[i][endC] = count ++;
            -- endC;
            
            for (int i = endC; i >= startC; i--)
                matrix[endR][i] = count ++;
            -- endR;
            
            for (int i = endR; i>= startR; i--)
                matrix[i][startC] = count ++;
            ++ startC;
        }
        return matrix;
    }
}