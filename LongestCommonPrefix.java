/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        int limit = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int len = 0;
            while (len < strs[i].length() && len < limit && strs[0].charAt(len) == strs[i].charAt(len))
                len ++;
            limit = len;
        }
        return strs[0].substring(0, limit);
    }
}