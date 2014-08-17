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

public class SubSetsWithDupRecrusive {
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
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(distinctNums); // For online juege purpose only
		findSubsetsWithDup(distinctNums, 0, new ArrayList<Integer>(), result,
                           appearCount);
		return result;
	}
    
	private void findSubsetsWithDup(Integer[] distinctNums, int depth,
                                    List<Integer> path, List<List<Integer>> result,
                                    Map<Integer, Integer> appearCount) {
		if (depth == distinctNums.length) {
			result.add(new ArrayList<Integer>(path));
			return;
		}
        
		int nextNum = distinctNums[depth];
		int appear = appearCount.get(nextNum);
		for (int i = 0; i <= appear; i++) {
			findSubsetsWithDup(distinctNums, depth + 1, path, result,
                               appearCount);
			path.add(nextNum);
		}
        
		for (int i = 0; i <= appear; i++) {
			path.remove(path.size() - 1);
		}
	}
}