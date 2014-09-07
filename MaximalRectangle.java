/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 */

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int ROW = matrix.length;
        int COL = (ROW == 0) ? 0 : matrix[0].length;
        int[][] areaHist = new int[ROW][COL + 1];

        for (int row = 0; row < ROW; row++) {
            for (int col = COL - 1; col >= 0; col--) {
                areaHist[row][col] = (matrix[row][col] == '0') ? 0
                        : 1 + areaHist[row][col + 1];
            }
        }

        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int col = 0; col < COL; col++) {
            stack.clear();
            for (int row = 0; row < ROW;) {
                if (stack.isEmpty()
                        || areaHist[row][col] >= areaHist[stack.peek()][col]) {
                    stack.push(row++);
                } else {
                    int topIndex = stack.pop();
                    int width = stack.isEmpty() ? row : row - stack.peek() - 1;
                    maxArea = Math
                            .max(maxArea, width * areaHist[topIndex][col]);
                }
            }

            while (!stack.isEmpty()) {
                int topIndex = stack.pop();
                int width = stack.isEmpty() ? ROW : ROW - stack.peek() - 1;
                maxArea = Math.max(maxArea, width * areaHist[topIndex][col]);
            }
        }

        return maxArea;
    }
}