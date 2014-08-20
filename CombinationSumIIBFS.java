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

public class CombinationSumIIBFS {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        Queue<List<Integer>> pathQueue = new LinkedList<List<Integer>>();
        Queue<Integer> indexQueue = new LinkedList<Integer>();
        pathQueue.offer(new ArrayList<Integer>());
        indexQueue.offer(0);
        Arrays.sort(num);
        while (!pathQueue.isEmpty()) {
            List<Integer> currPath = pathQueue.poll();
            int currIndex = indexQueue.poll();
            int currSum = getSumFromList(currPath);
            if (currSum == target) {
                result.add(currPath);
            }
            int previous = -1;
            for (int i = currIndex; i < num.length; i++) {
                int nextValue = num[i];
                if (nextValue == previous)
                    continue;
                    
                if (currSum + nextValue <= target) {
                    List<Integer> nextPath = new ArrayList<Integer>(currPath);
                    nextPath.add(nextValue);
                    previous = nextValue;
                    pathQueue.offer(nextPath);
                    indexQueue.offer(i + 1);
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