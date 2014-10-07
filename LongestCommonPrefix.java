/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
            
        String base = strs[0];
        int lenLimit = base.length();
        for (int i = 1; i < strs.length; i++) {
            lenLimit = findCommonPrefixEnd(base, strs[i], lenLimit);
            if (lenLimit == 0)
                break;
        }
        return base.substring(0, lenLimit);
    }
    
    private int findCommonPrefixEnd(String first, String second, int lenLimit) {
        int len = Math.min(Math.min(first.length(), second.length()), lenLimit);
        int index = 0;
        while (index < len && first.charAt(index) == second.charAt(index))
            index++;
        return index;
    }
}