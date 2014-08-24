/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * 
 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] You should return
 * [1,2,3,6,9,8,7,4,5].
 */

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int ROW_NUM = matrix.length;
        if (ROW_NUM == 0)
            return result;
        int COL_NUM = matrix[0].length;
        int startRow = 0, endRow = ROW_NUM - 1;
        int startCol = 0, endCol = COL_NUM - 1;

        while (true) {
            for (int col = startCol; col <= endCol; col++)
                result.add(matrix[startRow][col]);
            if (++startRow > endRow)
                break;

            for (int row = startRow; row <= endRow; row++)
                result.add(matrix[row][endCol]);
            if (--endCol < startCol)
                break;

            for (int col = endCol; col >= startCol; col--)
                result.add(matrix[endRow][col]);
            if (--endRow < startRow)
                break;

            for (int row = endRow; row >= startRow; row--)
                result.add(matrix[row][startCol]);
            if (++startCol > endCol)
                break;
        }
        return result;
    }
}