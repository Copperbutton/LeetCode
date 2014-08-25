/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
 */

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        int start = 0, end = 0;
        while (end < A.length) {
            while (end < A.length && A[start] == A[end])
                end++;
            if (end < A.length && start + 1 < A.length)
                A[start + 1] = A[end];
            start++;
        }
        return start;
    }
}