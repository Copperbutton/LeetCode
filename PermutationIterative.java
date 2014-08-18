/**
 * Given a collection of numbers, return all possible permutations.
 *
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 **/
public class PermutationIterative {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length; i++) {
            int resultSize = result.size();
            for (int j = 0; j < resultSize; j++) {
                List<Integer> oldList = result.get(j);
                for (int n : num) {
                    if (oldList.contains(n))
                        continue;
                    List<Integer> newList = new ArrayList<Integer>(oldList);
                    newList.add(n);
                    result.add(newList);
                }
            }
            result = result.subList(resultSize, result.size());
        }
        return result;
    }
}