/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 *
 * For example, [1,1,2] have the following unique permutations: [1,1,2],
 * [1,2,1], and [2,1,1].
 **/
public class PermutationWithDupInterative {
    public List<List<Integer>> permuteUnique(int[] num) {
        Map<Integer, Integer> numExpected = new HashMap<Integer, Integer>();
        
        for (int n : num) {
            int count = 1;
            if (numExpected.containsKey(n))
                count = numExpected.get(n) + 1;
            numExpected.put(n, count);
        }
        
        Set<Integer> keySet = numExpected.keySet();
        Integer[] uniqueNums = keySet.toArray(new Integer[keySet.size()]);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int loopCount = 0; loopCount < num.length; loopCount++) {
            int resultSize = result.size();
            for (int i = 0; i < resultSize; i++) {
                List<Integer> oldList = result.get(i);
                for (Integer uniqueN : uniqueNums) {
                    int used = 0;
                    for (int n : oldList)
                        if (n == uniqueN)
                            used++;
                    if (used == numExpected.get(uniqueN))
                        continue;
                    List<Integer> newList = new ArrayList<Integer>(oldList);
                    newList.add(uniqueN);
                    result.add(newList);
                }
            }
            result = result.subList(resultSize, result.size());
        }
        
        return result;
    }
}