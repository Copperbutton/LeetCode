/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note: You may assume that A has enough space (size that is greater or equal
 * to m + n) to hold additional elements from B. The number of elements
 * initialized in A and B are m and n respectively.
 */

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int indexA = m - 1, indexB = n - 1, mergeIndex = m + n - 1;
        while (mergeIndex >= 0) {
            int next = 0;
            if (indexA >= 0 && indexB >= 0) {
                if (A[indexA] > B[indexB]) {
                    next = A[indexA];
                    indexA--;
                } else {
                    next = B[indexB];
                    indexB--;
                }
            } else if (indexA >= 0) {
                next = A[indexA];
                indexA--;
            } else if (indexB >= 0) {
                next = B[indexB];
                indexB--;
            }

            A[mergeIndex] = next;
            mergeIndex--;
        }
    }
}