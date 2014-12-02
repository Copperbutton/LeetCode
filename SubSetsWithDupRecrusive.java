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
        Arrays.sort(num);
        Set<List<Integer>> result = new HashSet<List<Integer>> ();
        findSubset(num, 0, new LinkedList<Integer> (), result);
        List<List<Integer>> ret = new ArrayList(result);
        return ret;
    }
    
    private void findSubset(int[] num, int start, LinkedList<Integer> path, Set<List<Integer>> result) {
        if (start == num.length) {
            List<Integer> newPath = new ArrayList<Integer> (path);
            if (!result.contains(newPath))
                result.add(newPath);
            return;
        }
        
        int prev = -1;
        for (int index = start; index < num.length; index++) {
            if (index != start && prev == num[index])
                continue;
                
            prev = num[index];
            findSubset(num, index + 1, path, result);
            path.add(num[index]);
            findSubset(num, index + 1, path, result);
            path.removeLast();
        }
     }
}