/**
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
 */
public class ImplementStrStr {
    public String strStr(String haystack, String needle) {
        if (needle == null)
            return haystack;
        if (haystack == null)
            return null;

        String result = null;
        char[] haystackChs = haystack.toCharArray();
        char[] needleChs = needle.toCharArray();
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean matched = true;
            for (int n = 0, h = i; n < needle.length(); n++, h++) {
                if (needleChs[n] != haystackChs[h]) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                result = haystack.substring(i, haystack.length());
                break;
            }
        }
        return result;
    }
}