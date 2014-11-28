/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle [ [2], [3,4], [6,5,7], [4,1,8,3] ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return -1;
        int len = triangle.size();
        int[] minPath = new int[len + 1];
        ArrayList<List<Integer>> copy = new ArrayList<List<Integer>> (triangle);
        for (int i = len - 1; i >= 0; i--) {
            List<Integer> row = copy.get(i);
            int index = 0;
            for (int val : row) {
                minPath[index] = Math.min(minPath[index], minPath[index + 1]) + val;
                index ++;
            }
        }
        return minPath[0];
    }
}