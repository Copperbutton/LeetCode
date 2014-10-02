/**
 * Find the contiguous subarray within an array (containing at least one number) which has      
 * the largest product.
 *
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */

public class Solution {
    public int maxProduct(int[] A) {
        int size = A.length;
        int[][] product = new int[size][size];
        int maxProduct = Integer.MIN_VALUE;
        for (int row = 0; row < size; row++) {
            product[row][row] = A[row];
            for (int col = row + 1; col < size; col ++) {
                product[row][col] = A[col] * product[row][col - 1];
                maxProduct = Math.max(product[row][col], maxProduct);
            }
        }
        return maxProduct;
    }
}