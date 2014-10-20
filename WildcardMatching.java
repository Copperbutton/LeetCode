/**
 * '?' Matches any single character. '*' Matches any sequence of characters
 * (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false isMatch("aa", "*") → true isMatch("aa", "a*") →
 * true isMatch("ab", "?*") → true isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {
    public boolean isMatch(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        boolean[][] isMatch = new boolean[len1 + 1][len2 + 1];
        isMatch[len1][len2] = true;
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                if (t.charAt(j) == '?' || s.charAt(i) == t.charAt(j))
                    isMatch[i][j] = isMatch[i + 1][j + 1];
                else
                    isMatch[i][j] = (t.charAt(j) == '*')
                            && (isMatch[i + 1][j] || isMatch[i][j + 1]);
            }
        }
        return isMatch[0][0];
    }
}