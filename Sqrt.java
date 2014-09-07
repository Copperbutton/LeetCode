/**
 * mplement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 */
public class Solution {
    public int sqrt(int x) {
        int left = 1, right = x / 2;
        int lastMid = 0;

        if (x < 2)
            return x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x / mid > mid) {
                lastMid = mid;
                left = mid + 1;
            } else if (x / mid < mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return lastMid;
    }
}