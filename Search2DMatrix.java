/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] Given target = 3, return
 * true.
 */

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean found = false;
        int ROW = matrix.length, COL = ROW > 0 ? matrix[0].length : 0;
        int start = 0, end = ROW * COL - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = matrix[mid / COL][mid % COL];
            if (target == val) {
                found = true;
                break;
            } else if (target < val) {
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return found;
    }
}