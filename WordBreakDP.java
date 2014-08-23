/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 */

public class WordBreakDP {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] breakable = new boolean[len + 1];
        breakable[len] = true;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (dict.contains(s.substring(i, j + 1)) && breakable[j + 1]) {
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[0];
    }
}