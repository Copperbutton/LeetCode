/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * click to show follow up.
 * 
 * Follow up: Did you use extra space? A straight forward solution using O(mn)
 * space is probably a bad idea. A simple improvement uses O(m + n) space, but
 * still not the best solution. Could you devise a constant space solution?
 */

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int ROW_NUM = matrix.length;
        if (ROW_NUM == 0)
            return;
        int COL_NUM = matrix[0].length;

        boolean[] zeroFoundInRow = new boolean[ROW_NUM];
        boolean[] zeroFoundInCol = new boolean[COL_NUM];

        for (int row = 0; row < ROW_NUM; row++) {
            for (int col = 0; col < COL_NUM; col++) {
                if (matrix[row][col] == 0) {
                    zeroFoundInRow[row] = true;
                    zeroFoundInCol[col] = true;
                }
            }
        }

        for (int row = 0; row < ROW_NUM; row++) {
            for (int col = 0; col < COL_NUM; col++) {
                if (zeroFoundInRow[row] || zeroFoundInCol[col])
                    matrix[row][col] = 0;
            }
        }
    }
}