/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * click to show follow up.
 * 
 * Follow up: A rather straight forward solution is a two-pass algorithm using
 * counting sort. First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 */

public class SortColorsPartitionWithBoundary {
    public void sortColors(int[] A) {
        int lower = partition(A, 1, 0, A.length - 1);
        partition(A, 2, lower, A.length - 1);
    }

    private int partition(int[] A, int bar, int lower, int upper) {
        while (lower <= upper) {
            while (upper >= lower && A[upper] >= bar)
                upper--;
            while (lower <= upper && A[lower] < bar)
                lower++;
            if (lower < upper) {
                int swap = A[lower];
                A[lower++] = A[upper];
                A[upper--] = swap;
            } else
                lower++;
        }
        return upper + 1;
    }
}