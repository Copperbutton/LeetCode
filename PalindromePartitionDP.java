/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 */
public class Solution {
    public List<List<String>> partition(String s) {
        int length = s.length();
        boolean[][] isValidPalind = new boolean[length][length];
        for (int left = length - 1; left >= 0; left--) {
            for (int right = left; right < length; right++) {
                isValidPalind[left][right] = ((s.charAt(left) == s
                        .charAt(right)) && (right - left < 2 || isValidPalind[left + 1][right - 1]));
            }
        }

        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        for (int i = 0; i < length; i++)
            map.put(i, new ArrayList<List<String>>());
        for (int left = length - 1; left >= 0; left--) {
            List<List<String>> currPartition = map.get(left);
            for (int right = left; right < length; right++) {
                if (isValidPalind[left][right]) {
                    String palindrome = s.substring(left, right + 1);
                    if (right + 1 < length) {
                        for (List<String> partFromRight : map.get(right + 1)) {
                            List<String> newPart = new LinkedList<String>(
                                    partFromRight);
                            newPart.add(0, palindrome);
                            currPartition.add(newPart);
                        }
                    } else {
                        List<String> newPart = new LinkedList<String>();
                        newPart.add(palindrome);
                        currPartition.add(newPart);
                    }
                }
            }
        }
        return map.get(0);
    }
}