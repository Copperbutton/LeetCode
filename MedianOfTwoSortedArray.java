/**
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 */

public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int A[], int B[]) {
        int totalLength = A.length + B.length;
        double result = 0;
        if (totalLength % 2 == 1)
            result = findKthNumber(A, B, totalLength / 2 + 1);
        else
            result = (findKthNumber(A, B, totalLength / 2) + findKthNumber(A,
                    B, totalLength / 2 + 1)) / 2;
        return result;
    }

    private double findKthNumber(int A[], int B[], int k) {
        if (A.length > B.length)
            return findKthNumber(B, A, k);

        if (A.length == 0)
            return B[k - 1];

        if (k == 1)
            return Math.min(A[0], B[0]);

        int indexA = Math.min(A.length, k / 2);
        int indexB = k - indexA;
        if (A[indexA - 1] < B[indexB - 1])
            return findKthNumber(Arrays.copyOfRange(A, indexA, A.length), B, k
                    - indexA);
        else if (A[indexA - 1] > B[indexB - 1])
            return findKthNumber(A, Arrays.copyOfRange(B, indexB, B.length), k
                    - indexB);
        else
            return A[indexA - 1];
    }

}