/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return 1 since the palindrome partitioning
 * ["aa","b"] could be produced using 1 cut.
 */

public class PalindromePartitionIIDP {
    public int minCut(String s) {
        int length = s.length();
        int[] minCut = new int[length + 1];
        for (int i = 0; i <= length; i++)
            minCut[i] = length - 1 - i;

        boolean[][] isValidPalind = new boolean[length][length];
        for (int left = length - 1; left >= 0; left--) {
            for (int right = left; right < length; right++) {
                if ((s.charAt(left) == s.charAt(right))
                        && (right - left < 2 || isValidPalind[left + 1][right - 1])) {
                    isValidPalind[left][right] = true;
                    minCut[left] = Math.min(minCut[left], minCut[right + 1] + 1);
                }
            }
        }
        return minCut[0];
    }
}