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
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int R = matrix.length;
        int C = matrix[0].length;
        
        int rowBegin = 0, rowEnd = R - 1;
        while (rowBegin <= rowEnd) {
            int mid = rowBegin + (rowEnd - rowBegin)/2;
            int comp = matrix[mid][0] - target;
            if (comp == 0)
                return true;
            else if (comp > 0) {
                rowEnd = mid - 1;
            } else
                rowBegin = mid + 1;
        }
        if (rowEnd < 0)
            return false;
        
        for (int colBegin = 0, colEnd = C - 1; colBegin <= colEnd;) {
            int mid = colBegin + (colEnd - colBegin)/2;
            int comp = matrix[rowEnd][mid] - target;
            if (comp == 0)
                return true;
            else if (comp > 0) {
                colEnd = mid - 1;
            } else
                colBegin = mid + 1;
        }
        return false;
    }
}