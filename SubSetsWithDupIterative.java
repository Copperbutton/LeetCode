/**
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 *
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,2], a solution
 * is:
 *
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 **/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Map<Integer, Integer> appearCount = new HashMap<Integer, Integer>();
        for (int n : num) {
            int count = 1;
            if (appearCount.containsKey(n))
                count = appearCount.get(n) + 1;
            appearCount.put(n, count);
        }
        Set<Integer> keySet = appearCount.keySet();
        Integer[] distinctNums = keySet.toArray(new Integer[keySet.size()]);
        Arrays.sort(distinctNums); // For online juege purpose only
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for (Integer next : distinctNums) {
            int resultSize = result.size();
            for (int i = 0; i < resultSize; i++) {
                int appear = appearCount.get(next);
                List<Integer> newNums = new ArrayList<Integer>();
                for (int j = 0; j < appear; j++) {
                    newNums.add(next);
                    List<Integer> newList = new ArrayList<Integer>(
                                                                   result.get(i));
                    newList.addAll(newNums);
                    result.add(newList);
                }
            }
        }
        return result;
    }
}