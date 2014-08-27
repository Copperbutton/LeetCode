/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

public class TrappingRainWaterStack {
    public int trap(int[] A) {
        int rainWater = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int rightBarPos = 0; rightBarPos < A.length; rightBarPos++) {
            int middleBar = 0;
            while (!stack.isEmpty()) {
                int leftBarPos = stack.peek();
                int leftBar = A[leftBarPos];
                int rightBar = A[rightBarPos];
                rainWater += (Math.min(leftBar, rightBar) - middleBar)
                        * (rightBarPos - leftBarPos - 1);
                middleBar = leftBar;
                if (A[rightBarPos] < A[leftBarPos])
                    break;
                else
                    stack.pop();
            }
            stack.push(rightBarPos);
        }
        return rainWater;
    }
}