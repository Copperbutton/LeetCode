/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 */

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        int start = 0, maxLen = 0;
        char[] chs = s.toCharArray();
        boolean[][] palind = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                palind[i][j] = (chs[i] == chs[j])
                        && (j - i < 2 || palind[i + 1][j - 1]);
                if (palind[i][j] && (j - i + 1 > maxLen)) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}