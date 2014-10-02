/**
 * Find the contiguous subarray within an array (containing at least one number) which has      
 * the largest product.
 *
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */

public class Solution {
    public int maxProduct(int[] A) {
        if (A.length == 0)
            return 0;
        int maxHere = A[0];
        int minHere = A[0];
        int maxProduct = A[0];
        for (int i = 1; i < A.length; i++) {
            int max = Math.max(Math.max(A[i] * maxHere, A[i] * minHere), A[i]);
            int min = Math.min(Math.min(A[i] * maxHere, A[i] * minHere), A[i]);
            maxProduct = Math.max(max, maxProduct);
            maxHere = max;
            minHere = min;
        }
        return maxProduct;
    }
}