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
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        findCombinationSum(candidates, target, 0, new LinkedList<Integer>(),
                result);
        return result;
    }

    private void findCombinationSum(int[] candidates, int target, int index,
            LinkedList<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<Integer>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int nextValue = candidates[i];
            if (nextValue <= target) {
                path.add(nextValue);
                findCombinationSum(candidates, target - nextValue, i, path,
                        result);
                path.removeLast();
            } else
                break;
        }
    }
}
