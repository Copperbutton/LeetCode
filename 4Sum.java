/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 * (ie, a ≤ b ≤ c ≤ d) The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 */

public class 4Sum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<List<Integer>> addedSolus = new HashSet<List<Integer>>();
        for (int i = 0; i < num.length - 3; i++) {
            for (int j = i + 1; j < num.length - 2; j++) {
                for (int k = j + 1, l = num.length - 1; k < l;) {
                    int sum = num[i] + num[j] + num[k] + num[l];
                    if (sum == target) {
                        List<Integer> solu = new ArrayList<Integer>();
                        solu.add(num[i]);
                        solu.add(num[j]);
                        solu.add(num[k]);
                        solu.add(num[l]);
                        if (!addedSolus.contains(solu)) {
                            addedSolus.add(solu);
                            result.add(solu);
                        }
                        k++;
                        l--;
                    } else if (sum > target)
                        l--;
                    else
                        k++;
                }
            }
        }
        return result;
    }
}
