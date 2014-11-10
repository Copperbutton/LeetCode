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
        Arrays.sort(num);
        boolean[] used = new boolean[num.length];
        findPermutes(num, used, result, new LinkedList<Integer> ());
        return result;
    }
    
    private void findPermutes(int[] num, boolean[] used, List<List<Integer>> result, LinkedList<Integer> path) {
        if (path.size() == num.length) {
            result.add(new ArrayList<Integer> (path));
            return;
        }
        
        Set<Integer> set = new HashSet<Integer> ();
        for (int i = 0; i < num.length; i++) {
            if (used[i] || set.contains(num[i]))
                continue;
            set.add(num[i]);
            
            path.add(num[i]);
            used[i] = true;
            findPermutes(num, used, result, path);
            used[i] = false;
            path.removeLast();
        }
    }
}