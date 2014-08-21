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
public class JumpGameIIGreedy {
    public int jump(int[] A) {
        if (A.length <= 1)
            return 0;
        int left = 0, right = 0, setp = 0;
        while (left <= right) {
            setp++;
            int oldRight = right;
            for (int i = left; i <= oldRight; i++) {
                int newRight = A[i] + i;
                if (newRight >= A.length - 1)
                    return setp;
                right = Math.max(right, newRight);
            }
            left = oldRight + 1;
        }
        return 0;
    }
}