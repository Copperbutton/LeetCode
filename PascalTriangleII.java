/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer> ();
        if (rowIndex < 0)
            return result;
        int[] cache = new int[rowIndex + 2];
        cache[1] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            int prev = cache[0];
            for (int j = 1; j <= i + 1; j++) {
                int tmp = cache[j];
                cache[j] += prev;
                prev = tmp;
            }
        }
        for (int i = 1; i < cache.length; i++)
            result.add(cache[i]);
        return result;
}