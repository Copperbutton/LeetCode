/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 */
public class LongestValidParentheseDPQ {
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int longestParen = 0;
        int len = s.length();
        char[] chs = s.toCharArray();
        boolean[][] validParen = new boolean[len][len];
        for (int i = 0; i < len; i ++) {
            validParen[i][i] = false;
            for (int j = 0; j < i; j ++) {
                validParen[i][j] = (chs[i] != chs[j]) && (j + 1 == i || validParen[i - 1][j + 1]);
                if (validParen[i][j])
                    longestParen = longestParen > i - j + 1 ? longestParen : i - j + 1;
            }
        }
        return longestParen;
    }
}