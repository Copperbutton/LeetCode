/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 2,3,6,7 and target 7, A solution set is: [7] [2,
 * 2, 3]
 */
public class CombinationSumDFS {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        findCombination(candidates, 0, new LinkedList<Integer> (), result, target);
        return result;
    }
    
    private void findCombination(int[] candidates, int start, LinkedList<Integer> path, List<List<Integer>> result, int target) {
        if (start == candidates.length || target <= 0) {
            if (target == 0) {
                result.add(new ArrayList<Integer> (path));
            }
            return;
        }
        
        for (int index = start; index < candidates.length; index ++) {
            int val = candidates[index];
            path.add(val);
            findCombination(candidates, index, path, result, target - val);
            path.removeLast();
        }
        
    }
}
