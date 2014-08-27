/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 */

public class RotateImage {
    public void rotate(int[][] matrix) {
        int ROW_NUM = matrix.length;
        if (ROW_NUM == 0)
            return;
        for (int row = 0; row < ROW_NUM; row++) {
            for (int col = 0; col < ROW_NUM - row; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[ROW_NUM - 1 - col][ROW_NUM - 1 - row];
                matrix[ROW_NUM - 1 - col][ROW_NUM - 1 - row] = tmp;
            }
        }

        for (int col = 0; col < ROW_NUM; col++) {
            for (int row = 0; row < ROW_NUM / 2; row++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[ROW_NUM - 1 - row][col];
                matrix[ROW_NUM - 1 - row][col] = tmp;
            }
        }
    }
}