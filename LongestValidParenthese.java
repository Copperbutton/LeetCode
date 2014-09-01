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

public class LongestValidParenthese {
    public int longestValidParentheses(String s) {
        int longestParen = 0, last = -1;
        Stack<Integer> stack = new Stack<Integer>();
        char[] chs = s == null ? new char[0] : s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    last = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty())
                        longestParen = Math.max(longestParen, i - last);
                    else
                        longestParen = Math.max(longestParen, i - stack.peek());
                }
            }
        }
        return longestParen;
    }
}