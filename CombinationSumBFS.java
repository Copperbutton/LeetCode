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
public class CombinationSumBFS {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        Queue<List<Integer>> pathQueue = new LinkedList<List<Integer>>();
        Queue<Integer> indexQueue = new LinkedList<Integer>();
        pathQueue.offer(new ArrayList<Integer>());
        indexQueue.offer(0);
        Arrays.sort(candidates);
        while (!pathQueue.isEmpty()) {
            List<Integer> currPath = pathQueue.poll();
            int currIndex = indexQueue.poll();
            int currSum = getSumFromList(currPath);
            if (currSum == target) {
                result.add(currPath);
            }
            for (int i = currIndex; i < candidates.length; i++) {
                int nextValue = candidates[i];
                if (currSum + nextValue <= target) {
                    List<Integer> nextPath = new ArrayList<Integer>(currPath);
                    nextPath.add(nextValue);
                    pathQueue.offer(nextPath);
                    indexQueue.offer(i);
                }
            }
        }
        return result;
    }

    private int getSumFromList(List<Integer> list) {
        int sum = 0;
        for (Integer value : list)
            sum += value;
        return sum;
    }
}
