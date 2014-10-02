/**
 * Given a collection of numbers, return all possible permutations.
 *
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 **/
public class PermutationRecrusive {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        findPermutation(num, new boolean[num.length], new LinkedList<Integer> (), result);
        return result;
    }
    
    private void findPermutation(int[] num, boolean[] used, LinkedList<Integer> path, List<List<Integer>> result) {
        if (path.size() == num.length) {
            result.add(new ArrayList<Integer> (path));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            path.add(num[i]);
            findPermutation(num, used, path, result);
            path.removeLast();
            used[i] = false;
        }
    }
}