/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if (A.length < 3)
            return A.length;
        int start = 0, end = 1, count = 1;
        while (end < A.length) {
            if (A[start] == A[end]) {
                if (count == 1) {
                    A[++start] = A[end];
                    count++;
                }
                end++;
            } else {
                A[++start] = A[end++];
                count = 1;
            }
        }
        return start + 1;
    }
}