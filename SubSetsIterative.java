/**
 * Given a set of distinct integers, S, return all possible subsets.
 *
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,3], a solution
 * is:
 *
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 **/
public class SubSetsIterative {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        Arrays.sort(S);
        for (int next : S) {
            int resultSize = result.size();
            for (int i = 0; i < resultSize; i++) {
                List<Integer> newList = new ArrayList<Integer>(result.get(i));
                newList.add(next);
                result.add(newList);
            }
        }
        return result;
    }
}