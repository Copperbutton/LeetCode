/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 */

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int n : num)
            numSet.add(n);
        int maxCount = 0;
        for (int i = 0; i < num.length; i++) {
            int left = num[i] - 1;
            int right = num[i] + 1;
            int count = 1;

            while (numSet.contains(left)) {
                numSet.remove(left);
                left--;
                count++;
            }

            while (numSet.contains(right)) {
                numSet.remove(right);
                right++;
                count++;
            }

            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}