/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 *
 * For example, If n = 4 and k = 2, a solution is:
 *
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 **/

public class CombinationRecrusive {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        findCombination(result, 0, n, k, new ArrayList<Integer>());
        return result;
    }
    
    private void findCombination(List<List<Integer>> result, int start,
                                 int end, int leftNum, List<Integer> path) {
        if (leftNum == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = start + 1; i <= end; i++) {
            path.add(i);
            findCombination(result, i, end, leftNum - 1, path);
            path.remove(path.size() - 1);
        }
    }
}