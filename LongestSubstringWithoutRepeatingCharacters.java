/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 */

public class LongestSubstringWithoutRepeatingCharacters {
    private static final int ASCIICH = 256;

    public int lengthOfLongestSubstring(String s) {
        int[] lastFoundPos = new int[ASCIICH];
        Arrays.fill(lastFoundPos, -1);
        int max = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if (lastFoundPos[ch] >= left) {
                max = Math.max(i - left, max);
                left = lastFoundPos[ch] + 1;
            }
            lastFoundPos[ch] = i;
        }
        return Math.max(s.length() - left, max);
    }
}