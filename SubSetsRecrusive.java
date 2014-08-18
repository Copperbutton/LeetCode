/**
 * Given a set of distinct integers, S, return all possible subsets.
 *
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,3], a solution
 * is:
 *
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 **/
public class SubSetsRecrusive {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        findSubsets(S, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void findSubsets(int[] S, int depth, List<Integer> path,
                            List<List<Integer>> result) {
        if (depth == S.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        int next = S[depth];
        
        /** Next int not choosed */
        findSubsets(S, depth + 1, path, result);
        
        /** Next in choosed */
        path.add(next);
        findSubsets(S, depth + 1, path, result);
        path.remove(path.size() - 1);
    }
}