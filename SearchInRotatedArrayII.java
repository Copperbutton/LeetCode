/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 */
public class SearchInRotatedArrayII {
    public boolean search(int[] A, int target) {
        int left = 0, right = A.length - 1;
        boolean found = false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                found = true;
                break;
            }

            if (A[mid] >= A[left]) {
                if (A[mid] > A[left]) {
                    if (target >= A[left] && target < A[mid])
                        right = mid - 1;
                    else
                        left = mid + 1;
                } else {
                    left++;
                }
            } else {
                if (target > A[mid] && target <= A[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return found;
    }
}