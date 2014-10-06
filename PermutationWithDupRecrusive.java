/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 *
 * For example, [1,1,2] have the following unique permutations: [1,1,2],
 * [1,2,1], and [2,1,1].
 **/
public class PermutationWithDupRecrusive {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        if (num == null)
            return result;
        int len = num.length;
        boolean[] used = new boolean[len];
        Arrays.sort(num);
        findPermutations(num, used, new LinkedList<Integer> (), result);
        return result;
    }
    
    private void findPermutations(int[] num, boolean[] used, LinkedList<Integer> path, List<List<Integer>> result) {
        if (path.size() == num.length) {
            result.add(new ArrayList<Integer> (path));
            return;
        }
        
        for (int index = 0; index < num.length; index++) {
            if (used[index])
                continue;
            path.add(num[index]);
            used[index] = true;
            findPermutations(num, used, path, result);
            used[index] = false;
            path.removeLast();
            while (index < num.length - 1 && num[index] == num[index + 1])
                index++;
        }
    }
}