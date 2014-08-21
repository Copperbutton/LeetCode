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

/* Time Limit Exceeds */
public class JumpGameIIBFS {
    public int jump(int[] A) {
        if (A.length <= 1)
            return 0;

        Queue<Integer> indexQueue = new LinkedList<Integer>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        indexQueue.offer(0);
        depthQueue.offer(0);
        int result = 0;
        while (!indexQueue.isEmpty()) {
            int currIndex = indexQueue.poll();
            int currDepth = depthQueue.poll();

            int rightMostIndex = currIndex + A[currIndex];
            if (rightMostIndex >= A.length - 1) {
                result = currDepth + 1;
                break;
            }

            for (int index = currIndex + 1; index <= rightMostIndex; index++) {
                indexQueue.offer(index);
                depthQueue.offer(currDepth + 1);
            }
        }
        return result;
    }
}