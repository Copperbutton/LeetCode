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
public class Solution {
    public void setZeroes(int[][] matrix) {
        int ROW_NUM = matrix.length;
        if (ROW_NUM == 0)
            return;
        int COL_NUM = matrix[0].length;

        boolean zeroInFirstRow = false;
        boolean zeroInFirstCol = false;

        for (int col = 0; col < COL_NUM; col++) {
            if (matrix[0][col] == 0) {
                zeroInFirstRow = true;
                break;
            }
        }

        for (int row = 0; row < ROW_NUM; row++) {
            if (matrix[row][0] == 0) {
                zeroInFirstCol = true;
                break;
            }
        }

        for (int row = 1; row < ROW_NUM; row++) {
            for (int col = 1; col < COL_NUM; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for (int row = 1; row < ROW_NUM; row++) {
            for (int col = 1; col < COL_NUM; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0)
                    matrix[row][col] = 0;
            }
        }

        if (zeroInFirstRow) {
            for (int col = 0; col < COL_NUM; col++)
                matrix[0][col] = 0;
        }

        if (zeroInFirstCol) {
            for (int row = 0; row < ROW_NUM; row++)
                matrix[row][0] = 0;
        }

    }
}