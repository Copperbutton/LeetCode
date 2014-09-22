/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note: You may assume that A has enough space (size that is greater or equal
 * to m + n) to hold additional elements from B. The number of elements
 * initialized in A and B are m and n respectively.
 */

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int indx1 = m -1;
        int indx2 = n - 1;
        int indx3 = m + n - 1;
        while (indx3 >= 0) {
            if (indx1 >= 0 && indx2 >= 0) {
                A[indx3--] = A[indx1] > B[indx2] ? A[indx1--] : B[indx2--];
            } else if (indx1 >= 0) {
                A[indx3--] = A[indx1--];
            } else if (indx2 >= 0) {
                A[indx3--] = B[indx2--];
            }
        }
    }
}