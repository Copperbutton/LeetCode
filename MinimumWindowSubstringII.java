public class Solution {
    public String minWindow(String S, String T) {
        int ASCII_NUM = 256;
        int count = 0;
        int minWinStart = 0;
        int minWindLen = Integer.MAX_VALUE;
        int[] expected = new int[ASCII_NUM];
        int[] found = new int[ASCII_NUM];

        for (int i = 0; i < T.length(); i++) {
            expected[T.charAt(i)]++;
        }

        for (int first = 0, last = 0; last < S.length(); last++) {
            char ch1 = S.charAt(last);
            if (expected[ch1] == 0)
                continue;
            found[ch1]++;
            if (expected[ch1] >= found[ch1])
                count++;
            if (count < T.length())
                continue;
            char ch2 = S.charAt(first);
            while (expected[ch2] == 0 || found[ch2] > expected[ch2]) {
                if (expected[ch2] != 0)
                    found[ch2]--;
                first++;
                ch2 = S.charAt(first);
            }
            int currWindLen = last - first + 1;
            if (currWindLen < minWindLen) {
                minWinStart = first;
                minWindLen = currWindLen;
            }
        }
        if (minWindLen == Integer.MAX_VALUE)
            return "";
        else
            return S.substring(minWinStart, minWinStart + minWindLen);
    }
}