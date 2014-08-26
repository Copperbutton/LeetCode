/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤
 * b ≤ c) The solution set must not contain duplicate triplets. For example,
 * given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 */

public class 3Sum {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < num.length - 2; i++) {
            int gap = 0 - num[i];
            for (int start = i + 1, end = num.length - 1; start < end;) {
                int twoSum = num[start] + num[end];
                if (gap == twoSum) {
                    List<Integer> solution = new ArrayList<Integer>();
                    solution.add(num[i]);
                    solution.add(num[start++]);
                    solution.add(num[end--]);
                    result.add(solution);
                    while (start < end && num[start] == num[start - 1])
                        start++;
                    while (start < end && num[end] == num[end + 1])
                        end--;
                } else if (gap > twoSum)
                    start++;
                else
                    end--;
            }
            while (i < num.length - 2 && num[i] == num[i + 1])
                i++;
        }
        return result;
    }
}