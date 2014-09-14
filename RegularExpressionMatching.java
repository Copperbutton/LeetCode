package interviewquestions.leetcode;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false isMatch("aa", "a*") → true isMatch("aa", ".*") →
 * true isMatch("ab", ".*") → true isMatch("aab", "c*a*b") → true
 */

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int indx1, int indx2) {
        if (indx2 == p.length())
            return indx1 == s.length();

        if (indx2 == p.length() - 1 || p.charAt(indx2 + 1) != '*') {
            if (indx1 == s.length()
                    || (s.charAt(indx1) != p.charAt(indx2) && p.charAt(indx2) != '.'))
                return false;
            else
                return isMatch(s, p, indx1 + 1, indx2 + 1);
        }

        while (indx1 != s.length()
                && (s.charAt(indx1) == p.charAt(indx2) || p.charAt(indx2) == '.')) {
            if (isMatch(s, p, indx1, indx2 + 2))
                return true;
            indx1++;
        }
        return isMatch(s, p, indx1, indx2 + 2);
    }
}
