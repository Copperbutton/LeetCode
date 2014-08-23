/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 */
public class DistinctSubsequenceDPMemo {
    public int numDistinct(String S, String T) {
        int SLen = S.length();
        int TLen = T.length();
        int[] distSubseq = new int[TLen + 1];
        distSubseq[TLen] = 1;
        for (int i = SLen - 1; i >= 0; i--) {
            int prev = distSubseq[TLen];
            for (int j = TLen - 1; j >= 0; j--) {
                int temp = distSubseq[j];
                distSubseq[j] += (S.charAt(i) == T.charAt(j)) ? prev : 0;
                prev = temp;
            }
        }
        return distSubseq[0];
    }
}