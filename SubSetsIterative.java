public class SubSetsIterative {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        result.add(new ArrayList<Integer> ());
        Arrays.sort(S);
        for (int next : S) {
            int resultSize = result.size();
            for (int i = 0; i < resultSize; i ++) {
                List<Integer> newList = new ArrayList<Integer> (result.get(i));
                newList.add(next);
                result.add(newList);
            }
        }
        return result;
    }
}