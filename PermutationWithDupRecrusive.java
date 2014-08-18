/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 *
 * For example, [1,1,2] have the following unique permutations: [1,1,2],
 * [1,2,1], and [2,1,1].
 **/
public class PermutationWithDupRecrusive {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, Integer> numExpected = new HashMap<Integer, Integer>();
        Map<Integer, Integer> numUsed = new HashMap<Integer, Integer>();
        
        for (int n : num) {
            int count = 1;
            if (numExpected.containsKey(n))
                count = numExpected.get(n) + 1;
            else
                numUsed.put(n, 0);
            numExpected.put(n, count);
        }
        
        Set<Integer> keySet = numExpected.keySet();
        Integer[] distinctNums = keySet.toArray(new Integer[keySet.size()]);
        Arrays.sort(distinctNums);
        findPermuteunique(distinctNums, num.length, result, numExpected,
                          numUsed, new ArrayList<Integer>());
        return result;
    }
    
    private void findPermuteunique(Integer[] distinctNums, int leftNumCount,
                                   List<List<Integer>> result, Map<Integer, Integer> numExpected,
                                   Map<Integer, Integer> numUsed, List<Integer> path) {
        if (leftNumCount == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (Integer num : distinctNums) {
            int numUsedCount = numUsed.get(num);
            if (numUsedCount == numExpected.get(num))
                continue;
            path.add(num);
            numUsed.put(num, numUsedCount + 1);
            findPermuteunique(distinctNums, leftNumCount - 1, result,
                              numExpected, numUsed, path);
            path.remove(path.size() - 1);
            numUsed.put(num, numUsedCount);
        }
    }
}