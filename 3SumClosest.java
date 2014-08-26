/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class 3SumClosest {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int result = 0;
        if (num.length < 3) {
            result = 0;
            for (int n : num)
                result += n;
        }

        int gap = Integer.MAX_VALUE;
        for (int i = 0; i < num.length - 2; i++) {
            for (int start = i + 1, end = num.length - 1; start < end;) {
                int currSum = num[i] + num[start] + num[end];
                int currentGap = Math.abs(currSum - target);
                if (gap > currentGap) {
                    result = currSum;
                    gap = currentGap;
                }

                if (currSum == target)
                    break;
                else if (currSum < target)
                    start++;
                else
                    end--;
            }
        }
        return result;
    }
}