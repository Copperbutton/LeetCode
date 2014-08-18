/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 *
 * For example, If n = 4 and k = 2, a solution is:
 *
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 **/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int loopCount = 0; loopCount < k; loopCount++) {
            int resultSize = result.size();
            for (int i = 0; i < resultSize; i++) {
                List<Integer> oldList = result.get(i);
                int start = oldList.isEmpty() ? 0 : oldList.get(oldList.size() - 1);
                for (int next = start + 1; next <= n; next ++) {
                    List<Integer> newList = new ArrayList<Integer>(oldList);
                    newList.add(next);
                    result.add(newList);
                }
            }
            result = result.subList(resultSize, result.size());
        }
        return result;
    }
}