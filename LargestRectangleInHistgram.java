/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * For example, Given height = [2,1,5,6,2,3], return 10.
 */

public class LargestRectangleInHistgram {
    public int largestRectangleArea(int[] height) {
        int maxRectArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length;) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i])
                stack.push(i++);
            else {
                int topIndex = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int currArea = width * height[topIndex];
                maxRectArea = Math.max(currArea, maxRectArea);
            }
        }

        while (!stack.isEmpty()) {
            int topIndex = stack.pop();
            int width = stack.isEmpty() ? height.length : height.length
                    - stack.peek() - 1;
            int currArea = width * height[topIndex];
            maxRectArea = Math.max(currArea, maxRectArea);
        }
        return maxRectArea;
    }
}