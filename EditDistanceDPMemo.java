/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character b) Delete a character c) Replace a character
 */

public class EditDistanceDPMemo {
    public int minDistance(String word1, String word2) {
        int word1Len = word1.length();
        int word2Len = word2.length();
        if (word1Len == 0 || word2Len == 0)
            return word1Len == 0 ? word2Len : word1Len;

        int[] minDist = new int[word2Len + 1];

        for (int col = word2Len; col >= 0; col--) {
            minDist[col] = word2Len - col;
        }

        int gap = 0;
        for (int row = word1Len - 1; row >= 0; row--) {
            gap = minDist[word2Len];
            minDist[word2Len] = word1Len - row;
            for (int col = word2Len - 1; col >= 0; col--) {
                int insert = 1 + minDist[col + 1];
                int delete = 1 + minDist[col];
                int tmp = minDist[col];
                gap += (word1.charAt(row) == word2.charAt(col) ? 0 : 1);
                minDist[col] = Math.min(insert, Math.min(delete, gap));
                gap = tmp;
            }
        }
        return minDist[0];
    }
}