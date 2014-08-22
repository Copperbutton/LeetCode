/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 */

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len + s2Len != s3.length())
            return false;

        boolean[][] interleave = new boolean[s1Len + 1][s2Len + 1];
        interleave[s1Len][s2Len] = true;

        for (int col = s2Len - 1; col >= 0; col--)
            interleave[s1Len][col] = s2.charAt(col) == s3.charAt(s1Len + col)
                    && interleave[s1Len][col + 1];

        for (int row = s1Len - 1; row >= 0; row--)
            interleave[row][s2Len] = s1.charAt(row) == s3.charAt(s2Len + row)
                    && interleave[row + 1][s2Len];

        for (int i = s1Len - 1; i >= 0; i--) {
            for (int j = s2Len - 1; j >= 0; j--) {
                interleave[i][j] = (s1.charAt(i) == s3.charAt(i + j) && interleave[i + 1][j])
                        || (s2.charAt(j) == s3.charAt(i + j) && interleave[i][j + 1]);
            }
        }
        return interleave[0][0];
    }
}