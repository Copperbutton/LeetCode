/**
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
 */
public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return haystack;
            
        int index = 0;
        while (index <= haystack.length() - needle.length()) {
            int step = 0;
            while (step < needle.length() && haystack.charAt(index + step) == needle.charAt(step))
                step ++;
            if (step == needle.length())
                return haystack.substring(index);
            else
                index ++;
        }
        return null;
    }
}