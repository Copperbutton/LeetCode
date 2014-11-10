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
        if (height == null)
            return 0;
        
        int maxArea = 0;
        Stack<Integer> indexStack = new Stack<Integer> ();
        for (int i = 0; i < height.length; i++) {
            while (!indexStack.isEmpty() && height[i] < height[indexStack.peek()]) {
                int top = height[indexStack.pop()];
                int width = indexStack.isEmpty() ? i : i - indexStack.peek() - 1;
                maxArea = Math.max(maxArea, top * width);
            }
            indexStack.push(i);
        }
        
        while (!indexStack.isEmpty()) {
            int top = height[indexStack.pop()];
            int width = indexStack.isEmpty() ? height.length : height.length - indexStack.peek() - 1;
            maxArea = Math.max(maxArea, top * width);
        }
        
        return maxArea;
    }
}