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
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        findCombine(n, k, 1, new LinkedList<Integer> (), result);
        return result;
    }
    
    private void findCombine(int n, int k, int start, LinkedList<Integer> path, List<List<Integer>> result) {
        if (path.size() == k|| path.size() + (n - start + 1) < k) {
            if (path.size() == k)
                result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int index = start; index <= n; index ++) {
            path.addLast(index);
            findCombine(n, k, start + 1, path, result);
            path.removeLast();
        }
    }
}