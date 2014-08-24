/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 */
public class MinimumSubstringWindow {
    private static final int ASCII_NUM = 256;

    public String minWindow(String S, String T) {
        int count = 0, minWind = Integer.MAX_VALUE, minWindStart = 0;
        int[] found = new int[ASCII_NUM];
        int[] expected = new int[ASCII_NUM];
        char[] sArray = S.toCharArray();
        char[] tArray = T.toCharArray();
        int start = 0;
        for (char ch : tArray)
            expected[ch]++;

        for (int end = 0; end < S.length(); end++) {
            char ch = sArray[end];
            if (expected[ch] != 0) {
                found[ch]++;
                if (found[ch] <= expected[ch] && count < T.length()) {
                    count++;
                }
                if (count == T.length()) {
                    for (char startCh = sArray[start]; expected[startCh] == 0
                            || found[startCh] > expected[startCh]; startCh = sArray[start]) {
                        start++;
                        if (expected[startCh] != 0)
                            found[startCh]--;
                    }

                    int currWind = end - start + 1;
                    if (currWind < minWind) {
                        minWind = currWind;
                        minWindStart = start;
                    }
                }
            }
        }
        if (minWind == Integer.MAX_VALUE)
            return "";
        else
            return S.substring(minWindStart, minWindStart + minWind);
    }
}