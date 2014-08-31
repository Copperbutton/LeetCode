/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String cmpBase = strs.length > 0 ? strs[0] : "";
        int endIndex = cmpBase.length() - 1;
        for (int i = 1; i < strs.length; i++) {
            String cmpNext = strs[i];
            endIndex = Math.min(endIndex, cmpNext.length() - 1);
            for (int j = 0; j <= endIndex; j++) {
                if (cmpBase.charAt(j) != cmpNext.charAt(j)) {
                    endIndex = j - 1;
                    break;
                }
            }
        }
        return cmpBase.substring(0, endIndex + 1);
    }
}