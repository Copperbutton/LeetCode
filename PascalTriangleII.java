/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> nextRow = new ArrayList<Integer>();

        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            nextRow.add(1);
            for (int j = 0; j < result.size() - 1; j++) {
                int nextNum = result.get(j) + result.get(j + 1);
                nextRow.add(nextNum);
            }
            nextRow.add(1);
            List<Integer> tmp = result;
            result = nextRow;
            nextRow = tmp;
            nextRow.clear();
        }
        return result;
    }
}