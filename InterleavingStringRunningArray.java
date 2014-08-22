/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 */

public class InterleavingStringRunningArray {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if(s1Len + s2Len != s3.length())
            return false;
        
        boolean[] interleave = new boolean[s2Len + 1];
        interleave[s2Len] = true;
        for (int s2Index = s2Len - 1; s2Index >= 0; s2Index --)
            interleave[s2Index] = s2.charAt(s2Index) == s3.charAt(s1Len + s2Index) && interleave[s2Index + 1];
        
        for (int i = s1Len - 1; i >= 0; i --) {
            interleave[s2Len] = s1.charAt(i) == s3.charAt(s2Len + i) && interleave[s2Len];
            for (int j = s2Len - 1; j >= 0; j --) {
                interleave[j] = (s1.charAt(i) == s3.charAt(i + j) && interleave[j]) ||
                                (s2.charAt(j) == s3.charAt(i + j) && interleave[j + 1]);
                
            }
        }
        return interleave[0];
    }
}