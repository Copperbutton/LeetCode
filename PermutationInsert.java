/**
 * Given a collection of numbers, return all possible permutations.
 *
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 **/
public class PermutationInsert {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        result.add(new ArrayList<Integer> ());
        for (int n : num) {
            int resultSize = result.size();
            for (int i = 0; i < resultSize; i ++ ) {
                List<Integer> insertList = result.get(i);
                for (int j = 0; j <= insertList.size(); j ++) {
                    List<Integer> newList = new ArrayList<Integer> (insertList);
                    newList.add(j, n);
                    result.add(newList);
                }
            }
            result = result.subList(resultSize, result.size());
        }
        return result;
    }
}