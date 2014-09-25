/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 */

public class Solution {
    public int jump(int[] A) {
        int len = A.length;
        if (len == 0)
            return 0;
        int[] minStep = new int[len];
        minStep[0] = 0;
        for (int i = len - 2; i >= 0; i--) {
            minStep[i] = Integer.MAX_VALUE;
            for (int j = len - 1; j > i; j--) {
                minStep[i] = i + A[i] >= j ? Math.min(minStep[j] + 1, minStep[i]) : minStep[i];
            }
        }
        return minStep[0];
    }
}