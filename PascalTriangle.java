/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 */

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return result;
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        result.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1);
            List<Integer> currRow = new ArrayList<Integer>();
            currRow.add(prevRow.get(0));
            for (int j = 0; j < prevRow.size() - 1; j++) {
                int nextNum = prevRow.get(j) + prevRow.get(j + 1);
                currRow.add(nextNum);
            }
            currRow.add(prevRow.get(prevRow.size() - 1));
            result.add(currRow);
        }
        return result;
    }
}