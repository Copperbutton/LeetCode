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
        Set<Integer> set = new HashSet<Integer> ();
        for (int val : num)
            set.add(val);
        int maxLen = 0;
        for (int val : num) {
            set.remove(val);
            
            int right = val + 1;
            while (set.contains(right)) {
                set.remove(right++);
            }
            
            int left = val - 1;
            while (set.contains(left)) {
                set.remove(left--);
            }
            maxLen = Math.max(maxLen, right - left - 1);
        }
        return maxLen;
    }
}