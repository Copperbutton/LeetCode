/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set is:
 * [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 */

public class CombinationSumIIDFS {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        findCombinationSum(num, target, 0, new LinkedList<Integer>(), result);
        return result;
    }

    private void findCombinationSum(int[] num, int target, int index,
            LinkedList<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<Integer>(path));
            return;
        }

        int previous = -1;
        for (int i = index; i < num.length; i++) {
            int nextValue = num[i];
            if (nextValue == previous)
                continue;

            if (nextValue <= target) {
                path.add(nextValue);
                previous = nextValue;
                findCombinationSum(num, target - nextValue, i + 1, path, result);
                path.removeLast();
            } else
                break;
        }
    }
}