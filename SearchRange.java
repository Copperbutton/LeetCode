/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 */

public class SearchRange {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);
        int index = binarySearch(A, 0, A.length - 1, target);
        if (index != -1) {
            int left = index;
            int right = index;
            result[0] = left;
            result[1] = right;
            while ((left = binarySearch(A, 0, left - 1, target)) != -1)
                result[0] = left;
            while ((right = binarySearch(A, right + 1, A.length - 1, target)) != -1)
                result[1] = right;
        }
        return result;
    }

    private int binarySearch(int[] A, int start, int end, int target) {
        if (start > end)
            return -1;
        int mid = start + (end - start) / 2;
        int index = -1;
        if (A[mid] == target)
            index = mid;
        else if (A[mid] < target)
            index = binarySearch(A, mid + 1, end, target);
        else
            index = binarySearch(A, start, mid - 1, target);
        return index;
    }
}